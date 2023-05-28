package com.guy.class23b_andb_5;

public class Shift {

    private String key = "";
    private long startTime = 0;
    private long endTime = 0;
    private double salary = 0.0;
    private String workplace = "";
    private boolean nightShift = false;
    private String comments = "";

    public Shift() { }

    public String getKey() {
        return key;
    }

    public Shift setKey(String key) {
        this.key = key;
        return this;
    }

    public long getStartTime() {
        return startTime;
    }

    public Shift setStartTime(long startTime) {
        this.startTime = startTime;
        return this;
    }

    public long getEndTime() {
        return endTime;
    }

    public Shift setEndTime(long endTime) {
        this.endTime = endTime;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public Shift setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public String getWorkplace() {
        return workplace;
    }

    public Shift setWorkplace(String workplace) {
        this.workplace = workplace;
        return this;
    }

    public boolean isNightShift() {
        return nightShift;
    }

    public Shift setNightShift(boolean nightShift) {
        this.nightShift = nightShift;
        return this;
    }

    public String getComments() {
        return comments;
    }

    public Shift setComments(String comments) {
        this.comments = comments;
        return this;
    }
}
