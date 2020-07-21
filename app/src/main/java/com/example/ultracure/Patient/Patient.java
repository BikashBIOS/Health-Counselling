package com.example.ultracure.Patient;

public class Patient {
    private String pid, pname, pemail,pgender, page, paddress, ptown, pdistrict, ppincode, pphone;

    public Patient() {
    }

    public Patient(String pid, String pname, String pemail, String pgender, String page, String paddress, String ptown, String pdistrict, String ppincode, String pphone) {
        this.pid = pid;
        this.pname = pname;
        this.pemail = pemail;
        this.pgender = pgender;
        this.page = page;
        this.paddress = paddress;
        this.ptown = ptown;
        this.pdistrict = pdistrict;
        this.ppincode = ppincode;
        this.pphone = pphone;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPemail() {
        return pemail;
    }

    public void setPemail(String pemail) {
        this.pemail = pemail;
    }

    public String getPgender() {
        return pgender;
    }

    public void setPgender(String pgender) {
        this.pgender = pgender;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    public String getPtown() {
        return ptown;
    }

    public void setPtown(String ptown) {
        this.ptown = ptown;
    }

    public String getPdistrict() {
        return pdistrict;
    }

    public void setPdistrict(String pdistrict) {
        this.pdistrict = pdistrict;
    }

    public String getPpincode() {
        return ppincode;
    }

    public void setPpincode(String ppincode) {
        this.ppincode = ppincode;
    }

    public String getPphone() {
        return pphone;
    }

    public void setPphone(String pphone) {
        this.pphone = pphone;
    }
}
