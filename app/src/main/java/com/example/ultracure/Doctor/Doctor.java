package com.example.ultracure.Doctor;

public class Doctor {
    private String regid, name, speciality, qualification, designation, institution, email, mobile, account, hours;

    public Doctor() {
    }

    public Doctor(String regid, String name, String speciality, String qualification, String designation, String institution, String email, String mobile, String account, String hours) {
        this.regid = regid;
        this.name = name;
        this.speciality = speciality;
        this.qualification = qualification;
        this.designation = designation;
        this.institution = institution;
        this.email = email;
        this.mobile = mobile;
        this.account = account;
        this.hours = hours;
    }

    public String getRegid() {
        return regid;
    }

    public void setRegid(String regid) {
        this.regid = regid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}
