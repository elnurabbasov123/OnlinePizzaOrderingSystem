package model;

public class Kuryer {
    private int id;
    private String name;
    private String phone;
    private String vehicle;
    private String vehiclePlate;
    private boolean isEmpty;

    public Kuryer(){}

    public Kuryer(int id, String name, String phone, String vehicle, String vehiclePlate, boolean isEmpty) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.vehicle = vehicle;
        this.vehiclePlate = vehiclePlate;
        this.isEmpty = isEmpty;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public String toString() {
        return "Kuryer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", isEmpty=" + isEmpty +
                '}';
    }
}
