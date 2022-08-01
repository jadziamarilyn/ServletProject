package com.facilio.servlet;

public class Contact {
    private String name;
    private String age;
    private String mobileno;
    private String mail;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public Contact(String name, String age, String mobileno, String mail){
        this.name = name;
        this.age = age;
        this.mobileno = mobileno;
        this.mail = mail;
    }

}
