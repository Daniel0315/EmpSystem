package com.neuedu.entity;

public class Dept {
    private Integer dept_id;
    private String dname;
    private String location;

    public Dept() {
    }

    public Dept(String dname, String location) {
        this.dname = dname;
        this.location = location;
    }

    public Dept(Integer dept_id, String dname, String location) {
        this.dept_id = dept_id;
        this.dname = dname;
        this.location = location;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
