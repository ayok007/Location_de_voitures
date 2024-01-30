package com.example.locationdevoiture.Domain;

import java.util.ArrayList;

public class Form {
    private String fullName, phoneNumber, email, address;
    private ArrayList<Cars> orderedCars;

    public Form() {
    }

    public Form(String fullName, String phoneNumber, String email, String address, ArrayList<Cars> orderedCars) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.orderedCars = orderedCars;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Cars> getOrderedCars() {
        return orderedCars;
    }

    public void setOrderedCars(ArrayList<Cars> orderedCars) {
        this.orderedCars = orderedCars;
    }
}
