package com.example.bloodline;

public class Donor{

    private String bloodgroup;
    private String location;
    private String phonenumber;

    public Donor()
    {

    }

    public Donor(String bloodgroup, String location, String phonenumber) {
        this.bloodgroup = bloodgroup;
        this.location = location;
        this.phonenumber = phonenumber;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
