package com.marten.testdemo.bean;

public class Students {

    private String id;
    private String name;
    private String sex;
    private String age;
    private String classes;

    public Students() {

    }

    public Students(String id, String name, String sex, String age, String classes) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.classes = classes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
