package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.techelevator.exception.DaoException;
import com.techelevator.model.RegisterUserDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.techelevator.model.User;

@Component
public class JdbcUserDao implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getUserById(int userId) {
        User user = null;
        String sql = "SELECT u.user_id, u.username, u.password_hash, u.role, p.person_id, COALESCE(d.doctor_id, -1) AS doctor_id " +
                     "FROM users u " +
                     "JOIN person p ON u.user_id = p.user_id " +
                     "LEFT JOIN doctor d ON p.person_id = d.person_id " +
                     "WHERE u.user_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            if (results.next()) {
                user = mapRowToUser(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return user;
    }

    @Override
    public User getNewUserById(int userId) {
        User newUser = null;
        String sql = "SELECT user_id, username, password_hash, role " +
                "FROM users " +
                "WHERE user_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            if (results.next()) {
                newUser = mapRowToNewUser(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return newUser;
    }





    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT u.user_id, u.username, u.password_hash, u.role, p.person_id, COALESCE(d.doctor_id, -1) AS doctor_id " +
                     "FROM users u " +
                     "JOIN person p ON u.user_id = p.user_id " +
                     "LEFT JOIN doctor d ON p.person_id = d.person_id;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                    User user = mapRowToUser(results);
                    users.add(user);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return users;
    }

    @Override
    public User getUserByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");
        User user = null;
        String sql = "SELECT u.user_id, u.username, u.password_hash, u.role, p.person_id, COALESCE(d.doctor_id, -1) AS doctor_id " +
                     "FROM users u " +
                     "JOIN person p ON u.user_id = p.user_id " +
                     "LEFT JOIN doctor d ON p.person_id = d.person_id " +
                     "WHERE u.username = ?;";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, username);
            if (rowSet.next()) {
                user = mapRowToUser(rowSet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return user;

    }

    @Override
    public User createUser(RegisterUserDto user) {
        User newUser = null;
        String insertUserSql = "INSERT INTO users (username, password_hash, role) values (?, ?, ?) RETURNING user_id";
        String password_hash = new BCryptPasswordEncoder().encode(user.getPassword());
        String ssRole = user.getRole().toUpperCase().startsWith("ROLE_") ? user.getRole().toUpperCase() : "ROLE_" + user.getRole().toUpperCase();

        String insertPersonSql = "INSERT INTO person (user_id, first_name, last_name, email, date_of_birth) VALUES (?, ?, ?, ?, ?) RETURNING person_id;";
        try {
            int newUserId = jdbcTemplate.queryForObject(insertUserSql, int.class, user.getUsername(), password_hash, ssRole);
            newUser = getNewUserById(newUserId);

            int newPersonId = jdbcTemplate.queryForObject(insertPersonSql, int.class, newUserId, user.getFirstName(), user.getLastName(), user.getEmail(), user.getDateOfBirth());
            newUser.setPersonId(newPersonId);
            newUser.setDoctorId(-1);   // A newly created user can't be designated as a doctor yet.

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newUser;
    }


    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();

        user.setId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password_hash"));
        user.setAuthorities(Objects.requireNonNull(rs.getString("role")));
        user.setActivated(true);
        user.setPersonId(rs.getInt("person_id"));
        user.setDoctorId(rs.getInt("doctor_id"));
        return user;
    }


    private User mapRowToNewUser(SqlRowSet rs) {
        User user = new User();

        user.setId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password_hash"));
        user.setAuthorities(Objects.requireNonNull(rs.getString("role")));
        user.setActivated(true);
        return user;
    }


}
