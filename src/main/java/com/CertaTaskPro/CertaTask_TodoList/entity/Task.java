package com.CertaTaskPro.CertaTask_TodoList.entity;

import java.util.Date;

public class Task {

    private String title;
    private String desc;
    private Date creationDate;
    private Integer taskId;
    private TaskStatus status;
    private Double hoursWorked;

    public Task() {

    }

    public Task(String title, String desc, Date creationDate, Integer taskId, TaskStatus status, Double hoursWorked) {
        this.title = title;
        this.desc = desc;
        this.creationDate = creationDate;
        this.taskId = taskId;
        this.status = status;
        this.hoursWorked = hoursWorked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }


    public double totalHoursWorked() {
        double totalH = 0.0;
        return totalH += getHoursWorked();
    }


}