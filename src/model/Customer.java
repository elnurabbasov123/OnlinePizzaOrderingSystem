package model;

import java.math.BigDecimal;

public class Customer {
    private  int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String phone;
    private BigDecimal capital;

    public Customer(){}

    public String getPassword() {
        return password;
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer(int id, String login, String password, String name, String surname, String phone,BigDecimal capital) {
        this.id=id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.capital=capital;
    }

    public  int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
