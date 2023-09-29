package global;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GlobalData {

    private static GlobalData instance;

    public static GlobalData getInstance(){
        return instance==null? new GlobalData():instance;
    }

    private GlobalData(){

    }

    public  static List<Company> companies;

    public static List<Admin> admins;

    public static List<Customer> customers=new ArrayList<>();

    public static List<Pizza> pizzaList;

    public static List<Sous> sousList;

    public static List<Kuryer> kuryers;

    public static List<Order> orders=new ArrayList<>();

    public static int kuryerId;
    public static int cusId;
    public static long orderId;
    public static int pizzaId;
    public static int sousId;

    static {
        admins=List.of(
          new Admin("vidi030","manager123","Vidadi","Muradov","Manager"),
          new Admin("2","2","Elvin","Abbasov","Direktor")
        );

        pizzaList=List.of(
          new Pizza(++pizzaId,"Italiano",new BigDecimal(4.99),new BigDecimal(7.99),new BigDecimal(11.99)),
          new Pizza(++pizzaId,"Americano",new BigDecimal(5.99),new BigDecimal(8.99),new BigDecimal(12.99)),
          new Pizza(++pizzaId,"Mexicano",new BigDecimal(4.69),new BigDecimal(7.59),new BigDecimal(13.49)),
          new Pizza(++pizzaId,"Chicken Kickers",new BigDecimal(5.10),new BigDecimal(8.29),new BigDecimal(13.39)),
          new Pizza(++pizzaId,"Margherita",new BigDecimal(4.89),new BigDecimal(8.99),new BigDecimal(14.20)),
          new Pizza(++pizzaId,"Pepperoni",new BigDecimal(4.99),new BigDecimal(8.29),new BigDecimal(16.99))
        );

        kuryers=List.of(
                new Kuryer(++kuryerId,"Seid","Aliev","Moto","77-AA-077",true),
                new Kuryer(++kuryerId,"Ali","Candan","Moto","77-AZ-787",true),
                new Kuryer(++kuryerId,"Hesen","Aqayev","Moto","77-AE-658",true),
                new Kuryer(++kuryerId,"Mais","Medetov","Moto","77-AE-777",true),
                new Kuryer(++kuryerId,"Hesen","Kiwiyev","Moto","77-AE-222",true)
        );

        companies=List.of(
                new Company("Wolt","Semedzade 13A","+99455 318 68 78","4169318578698525"),
                new Company("Bolt","S.Memmedova 203A","+99455 275 75 75","4169783365899636")
        );

        sousList=List.of(
                new Sous(++sousId,"Ketcup",new BigDecimal(0.7)),
                new Sous(++sousId,"Barbecu",new BigDecimal(0.7)),
                new Sous(++sousId,"Mayonnaise",new BigDecimal(0.7)));

        customers=List.of(
                new Customer(++cusId,"1","1","Elnur","Abbasov","+994553016819",new BigDecimal(100))
        );

            }
}
