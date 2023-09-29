package model;

import java.math.BigDecimal;

public class Sous {
    private int id;
    private String name;
    private BigDecimal price;

    public Sous(){}

    public Sous(int id,String name, BigDecimal price) {
        this.id=id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "{"+name +", price="+price.doubleValue()+"$ }";
    }
}
