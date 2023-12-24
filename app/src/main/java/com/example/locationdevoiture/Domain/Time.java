package com.example.locationdevoiture.Domain;

public class Time {
    private int Id;
    private String value;

    public Time() {
    }

    @Override
    public String toString() {
        return  value ;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
