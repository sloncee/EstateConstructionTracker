package ru.vsu.csf.sofya_dorofeyeva.model;

public class Client {
    private int id;
    private String email;
    private String fullName;
    private String phone;


    public Client(int id, String email, String fullName, String phone) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + id +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
