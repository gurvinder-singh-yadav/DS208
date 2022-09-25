package com.rodavid20.firebasedemo.datamodel;

public class Student {
    private int id;
    private String name;
    private String departmentName;

    public Student(){
    }

    public Student(int id, String name, String departmentName){
        this.id = id;
        this.name = name;
        this.departmentName = departmentName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}

