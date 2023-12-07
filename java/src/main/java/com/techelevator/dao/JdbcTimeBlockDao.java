package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.TimeBlockDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcTimeBlockDao implements TimeBlockDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTimeBlockDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
/*    @Override
    public List<TimeBlockDto> getTimeBlocksByOfficeHours(String officeHoursStart, String officeHoursEnd){
        List<TimeBlockDto> timeBlocks = new ArrayList<>();

        String startLT = "'" + officeHoursStart + "'";
        System.out.println(officeHoursStart + " ==> " + startLT);
        String endLT = "'" + officeHoursEnd + "'";
        System.out.println(officeHoursEnd + " ==> " + endLT);

        String sql = "SELECT time_block_id, start_time FROM time_block " +
                     "WHERE start_time BETWEEN ? AND ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, startLT, endLT);
        while (results.next()) {
            timeBlocks.add(mapRowToTimeBlockDto(results));
        }
        return timeBlocks;
    }*/

    @Override
    public List<TimeBlockDto> getAllTimeBlocks() {
        List<TimeBlockDto> timeBlocks = new ArrayList<>();

        String sql = "SELECT time_block_id, start_time FROM time_block;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            timeBlocks.add(mapRowToTimeBlockDto(results));
        }
        return timeBlocks;
    }

    @Override
    public List<TimeBlockDto> getTimeBlocksByOfficeHours(int officeHoursStart, int officeHoursEnd){
        List<TimeBlockDto> timeBlocks = new ArrayList<>();

//        String startLT = "'" + officeHoursStart + "'";
//        System.out.println(officeHoursStart + " ==> " + startLT);
//        String endLT = "'" + officeHoursEnd + "'";
//        System.out.println(officeHoursEnd + " ==> " + endLT);

        String sql = "SELECT time_block_id, start_time FROM time_block " +
                "WHERE time_block_id BETWEEN ? AND ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeHoursStart, officeHoursEnd);
        while (results.next()) {
            timeBlocks.add(mapRowToTimeBlockDto(results));
        }
        return timeBlocks;
    }

    private TimeBlockDto mapRowToTimeBlockDto(SqlRowSet rowSet) {
        TimeBlockDto timeBlockDto = new TimeBlockDto();
        timeBlockDto.setTimeBlockId(rowSet.getInt("time_block_id"));
        timeBlockDto.setStartTime(rowSet.getTime("start_time").toLocalTime());
        timeBlockDto.setDuration(0);
        timeBlockDto.setScheduleStatusId(0);

        return timeBlockDto;
    }
}
