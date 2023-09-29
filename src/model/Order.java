package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Order {
    private long id;
    private Customer customer;
    private Kuryer kuryer;
    private BigDecimal orderAmount;
    private String deliveryLocation;
    private boolean onTheWay;
    private boolean isDelivered;
    private LocalDateTime startTime;
    private LocalDateTime deliveryTime;
    private List<List<Pizza>> pizza;
    private List<List<Sous>> sousList;

    private static long staticId;

    public Order() {}

    public Order(Customer customer, Kuryer kuryer,BigDecimal orderAmount, String deliveryLocation, boolean onTheWay, boolean isDelivered, LocalDateTime deliveryOrderTime, LocalDateTime deliveryTime,List<List<Pizza>> pizza,List<List<Sous>> sousList) {
        this.id=++staticId;
        this.customer = customer;
        this.kuryer=kuryer;
        this.orderAmount = orderAmount;
        this.deliveryLocation = deliveryLocation;
        this.onTheWay = onTheWay;
        this.isDelivered = isDelivered;
        this.startTime = deliveryOrderTime;
        this.deliveryTime = deliveryTime;
        this.pizza=pizza;
        this.sousList=sousList;
    }

    public Kuryer getKuryer() {
        return kuryer;
    }

    public void setKuryer(Kuryer kuryer) {
        this.kuryer = kuryer;
    }

    public List<List<Pizza>> getPizza() {
        return pizza;
    }

    public void setPizza(List<List<Pizza>> pizza) {
        this.pizza = pizza;
    }

    public List<List<Sous>> getSousList() {
        return sousList;
    }

    public void setSousList(List<List<Sous>> sousList) {
        this.sousList = sousList;
    }

    public static long getStaticId() {
        return staticId;
    }

    public static void setStaticId(long staticId) {
        Order.staticId = staticId;
    }

    public boolean isOnTheWay() {
        return onTheWay;
    }

    public void setOnTheWay(boolean onTheWay) {
        this.onTheWay = onTheWay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH':'mm");
        if (!sousList.isEmpty()) {
            return "---------------Cash Receipt---------------\n" +
                    "Start Date :" + formatter.format(startTime) + "\n" +
                    "End Date :" + formatter.format(deliveryTime) + "\n" +
                    "\n" +
                    "Username :" + customer.getLogin() + "\n" +
                    pizza + "\n" +
                    sousList + "\n" +
                    "\n" +
                    "Courier name :" + kuryer.getName() + "\n" +
                    "Courier phoneNumber :" + kuryer.getPhone() + "\n" +
                    "Courier vehicleType :" + kuryer.getVehicle() + "\n" +
                    "Courier vehiclePlate :" + kuryer.getVehiclePlate() + "\n" +
                    "\n" +
                    "Cash :" + orderAmount.doubleValue() + "$";
        }else {
            return "---------------Cash Receipt---------------\n" +
                    "Start Date :" + formatter.format(startTime) + "\n" +
                    "End Date :" + formatter.format(deliveryTime) + "\n" +
                    "\n" +
                    "Username :" + customer.getLogin() + "\n" +
                    pizza + "\n" +
                    "\n" +
                    "Courier name :" + kuryer.getName() + "\n" +
                    "Courier phoneNumber :" + kuryer.getPhone() + "\n" +
                    "Courier vehicleType :" + kuryer.getVehicle() + "\n" +
                    "Courier vehiclePlate :" + kuryer.getVehiclePlate() + "\n" +
                    "\n" +
                    "Cash :" + orderAmount.doubleValue() + "$";
        }
    }
}
