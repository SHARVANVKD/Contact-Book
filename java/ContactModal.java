package com.example.contactbook;

public class ContactModal {
    private String name;
    private String phone;
    private String email;
    private String namesAll;
    public ContactModal(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public ContactModal(String string) { this.namesAll = string; }
    public String getNamesAll() { return namesAll; }
    public void setNamesAll(String namesAll) { this.namesAll = namesAll; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
