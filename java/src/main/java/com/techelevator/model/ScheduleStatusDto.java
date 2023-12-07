package com.techelevator.model;

public class ScheduleStatusDto {
    private int scheduleStatusId;
    private String scheduleStatus;


    public ScheduleStatusDto(int scheduleStatusId, String scheduleStatus) {
        this.scheduleStatusId = scheduleStatusId;
        this.scheduleStatus = scheduleStatus;
    }

    public ScheduleStatusDto() {
    }

    public int getScheduleStatusId() {
        return scheduleStatusId;
    }

    public void setScheduleStatusId(int scheduleStatusId) {
        this.scheduleStatusId = scheduleStatusId;
    }

    public String getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(String scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }
}


