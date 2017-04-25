package com.example.quoctuan.spinner.model;


import java.io.Serializable;

public class Employee implements Serializable{

    private String name;
    private String dayStart;
    private int dayNumber;

    public Employee() {
    }

    public Employee(String name, String dayStart, int dayNumber) {
        this.name = name;
        this.dayStart = dayStart;
        this.dayNumber = dayNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    @Override
    public String toString() {
        return this.name+
                "\n Bắt đầ đi công tác vào thứ ["+this.dayStart+"]"+
                "\n Số ngày công tác dự kiến ="+this.dayNumber+"Ngày";
    }
}
