package model;

import java.math.BigDecimal;

public class Pizza {
    private int id;
    private String name;
    private BigDecimal smallPrice;
    private BigDecimal mediumPrice;
    private BigDecimal largePrice;

    private String sousName;
    private String size;
    private BigDecimal price;

    public Pizza(int id,String name, BigDecimal smallPrice, BigDecimal mediumPrice, BigDecimal largePrice) {
        this.id=id;
        this.name = name;
        this.smallPrice = smallPrice;
        this.mediumPrice = mediumPrice;
        this.largePrice = largePrice;
    }

    public String getSize() {
        return size;
    }

    public String getSousName() {
        return sousName;
    }

    public void setSousName(String sousName) {
        this.sousName = sousName;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPizzaSize(){
        if(this.price==smallPrice){
            return "Small";
        }else if(this.price==mediumPrice){
            return "Medium";
        }else if(this.price==largePrice){
            return "Large";
        }
        return "Not Found";
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSmallPrice() {
        return smallPrice;
    }

    public void setSmallPrice(BigDecimal smallPrice) {
        this.smallPrice = smallPrice;
    }

    public BigDecimal getMediumPrice() {
        return mediumPrice;
    }

    public void setMediumPrice(BigDecimal mediumPrice) {
        this.mediumPrice = mediumPrice;
    }

    public BigDecimal getLargePrice() {
        return largePrice;
    }

    public void setLargePrice(BigDecimal largePrice) {
        this.largePrice = largePrice;
    }

    @Override
    public String toString() {
        switch (size){
            case "Small"->price=getSmallPrice();
            case "Medium"->price=getMediumPrice();
            case "Large"->price=getLargePrice();
        }
            return "Pizza{" +
                    "name='" + name +
                    " , size=" + size +
                    " , price=" + price.doubleValue()+"$ }";
    }
}
