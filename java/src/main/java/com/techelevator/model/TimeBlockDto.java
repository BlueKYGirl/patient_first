package com.techelevator.model;

import javax.validation.constraints.NotEmpty;
import java.time.LocalTime;

public class TimeBlockDto {

    private int timeBlockId;

    private LocalTime startTime;

    private int duration;
    private int scheduleStatusId;

    public TimeBlockDto(int timeBlockId, LocalTime startTime, int duration, int scheduleStatusId) {
        this.timeBlockId = timeBlockId;
        this.startTime = startTime;
        this.duration = duration;
        this.scheduleStatusId = scheduleStatusId;
    }

    public TimeBlockDto() {
    }

    public int getTimeBlockId() {
        return timeBlockId;
    }

    public void setTimeBlockId(int timeBlockId) {
        this.timeBlockId = timeBlockId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getScheduleStatusId() {
        return scheduleStatusId;
    }

    public void setScheduleStatusId(int scheduleStatusId) {
        this.scheduleStatusId = scheduleStatusId;
    }
}
