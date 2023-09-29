package main;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        BigDecimal s=new BigDecimal(10);
        BigDecimal s2=new BigDecimal(3);

        System.out.println(s.subtract(s2).doubleValue());
    }
}
