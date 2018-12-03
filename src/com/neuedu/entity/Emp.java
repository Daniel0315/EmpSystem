package com.neuedu.entity;

public class Emp {
    private Integer emp_id;
    private String name;
    private String phone;
    private String sex;
    private Integer salary;
    private Integer dept_id;
    private Dept dept;

    public Emp() {
    }

    public Emp(String name, String phone, String sex, Integer salary, Integer dept_id) {
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.salary = salary;
        this.dept_id = dept_id;
    }

    public Emp(Integer emp_id, String name, String phone, String sex, Integer salary, Integer dept_id) {
        this.emp_id = emp_id;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.salary = salary;
        this.dept_id = dept_id;
    }

    public Emp(Integer emp_id, String name, String phone, String sex, Integer salary, Integer dept_id, Dept dept) {
        this.emp_id = emp_id;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.salary = salary;
        this.dept_id = dept_id;
        this.dept = dept;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
