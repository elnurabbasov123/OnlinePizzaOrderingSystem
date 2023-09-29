package model;

public class Company {
    private String name;
    private String location;
    private String phone;
    private String cartNum;

//    private static Company instance;
//
//    public static Company getInstance() {
//        return instance == null ? new Company() : instance;
//    }

    public Company(){}
    public Company(String name, String location, String phone, String cartNum) {
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.cartNum = cartNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCartNum() {
        return cartNum;
    }

    public void setCartNum(String cartNum) {
        this.cartNum = cartNum;
    }
}
