package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.ScheduleStatusDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcScheduleStatusDao implements ScheduleStatusDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcScheduleStatusDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<ScheduleStatusDto> getScheduleStatuses() {
        List<ScheduleStatusDto> scheduleStatuses = new ArrayList<>();
        String sql = "SELECT schedule_status_id, schedule_status FROM schedule_status;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            scheduleStatuses.add(mapRowToScheduleStatusDto(results));
        }
        return scheduleStatuses;
    }

    private ScheduleStatusDto mapRowToScheduleStatusDto(SqlRowSet rowSet) {
        ScheduleStatusDto scheduleStatusDto = new ScheduleStatusDto();
        scheduleStatusDto.setScheduleStatusId(rowSet.getInt("schedule_status_id"));
        scheduleStatusDto.setScheduleStatus(rowSet.getString("schedule_status"));

        return scheduleStatusDto;
    }
}
