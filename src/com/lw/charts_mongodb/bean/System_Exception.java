package com.lw.charts_mongodb.bean;

/**
 * @author wei.Li by 14/10/21.
 */
public class System_Exception {

    private String id;
    private String system_name;
    private int num;
    private int duration;
    private int duration_avg;
    private int num_year;
    private int duration_year;

    public System_Exception() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSystem_name() {
        return system_name;
    }

    public void setSystem_name(String system_name) {
        this.system_name = system_name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration_avg() {
        return duration_avg;
    }

    public void setDuration_avg(int duration_avg) {
        this.duration_avg = duration_avg;
    }

    public int getNum_year() {
        return num_year;
    }

    public void setNum_year(int num_year) {
        this.num_year = num_year;
    }

    public int getDuration_year() {
        return duration_year;
    }

    public void setDuration_year(int duration_year) {
        this.duration_year = duration_year;
    }
}
