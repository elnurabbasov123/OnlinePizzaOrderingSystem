package service.impl;

import enums.Exceptions;
import exceptions.GlobalException;
import global.GlobalData;
import model.*;
import service.inter.MenuService;
import service.inter.PizzaService;
import util.InputUtil;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MenuServiceImpl implements MenuService {
    PizzaService pizzaService=new PizzaServiceImpl();

    @Override
    public int menu() {
        int option = InputUtil.getInstance().inputInt("[0]->Exit\n" +
                "[1]->Admin\n" +
                "[2]->Customer\n" +
                "Select:");
        switch (option) {
            case 0:
                System.exit(0);
                break;
            case 1:
                Admin admin=null;
                boolean ok = false;
                String login = InputUtil.getInstance().inputString("Login :");
                String password = InputUtil.getInstance().inputString("Password :");
                for (int i = 0; i < GlobalData.admins.size(); i++) {
                     admin = GlobalData.admins.get(i);
                    if (admin.getLogin().equals(login)
                            && admin.getPassword().equals(password)) {
                        System.out.println("Welcome mr. " + admin.getName());
                        ok = true;
                    }
                }
                if (ok) {
                    adminMenu(admin);
                } else {
                    throw new GlobalException(Exceptions.NOT_REGISTERED_EXCEPTION);
                }
                break;
            case 2:
                int option2 = InputUtil.getInstance().inputInt("[0]->Exit\n" +
                        "[1]->Login\n" +
                        "[2]->Sign up\n" +
                        "[3]->Back\n" +
                        "Select :");
                switch (option2) {
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        String login2 = InputUtil.getInstance().inputString("login :");
                        String password2 = InputUtil.getInstance().inputString("password :");

                        for (int i = 0; i < GlobalData.customers.size(); i++) {
                            if (GlobalData.customers.get(i).getLogin().equals(login2)
                                    && GlobalData.customers.get(i).getPassword().equals(password2)) {
                                customerMenu(GlobalData.customers.get(i));
                            } else {
                                throw new GlobalException(Exceptions.NOT_REGISTERED_EXCEPTION);
                            }
                        }
                        break;
                    case 2:
                        String name = InputUtil.getInstance().inputString("Enter name :");
                        String surname = InputUtil.getInstance().inputString("Enter surname :");
                        String log = InputUtil.getInstance().inputString("Enter login :");
                        String pass = InputUtil.getInstance().inputString("Enter password :");
                        String phone = InputUtil.getInstance().inputString("Enter phoneNumber :");
                        String money=InputUtil.getInstance().inputString("Enter your amount :");
                        double d=Double.valueOf(money);

                        Customer customer = new Customer(++GlobalData.cusId, log, pass, name, surname, phone,new BigDecimal(d));
                        GlobalData.customers.add(customer);
                        customerMenu(customer);
                        break;
                    case 3:
                        menu();
                        break;
                    default:
                        throw new GlobalException(Exceptions.INVALID_FUNCTION);
                }
            default:
                throw new GlobalException(Exceptions.INVALID_FUNCTION);
        }
        return 0;
    }

    @Override
    public void adminMenu(Admin admin) {
        int option = InputUtil.getInstance().inputInt("[0]->Exit\n" +
                "[1]->Back\n" +
                "[2]->Add Courier\n" +
                "[3]->Track Orders\n" +
                "[4]->View Couriers\n" +
                "[5]->View Customers\n" +
                "Select :");
        switch (option) {
            case 0:
                System.exit(0);
                break;
            case 1:
                menu();
                break;
            case 2:
                String name = InputUtil.getInstance().inputString("Enter kuryer name:");
                String surname = InputUtil.getInstance().inputString("Enter kuryer surname:");
                Kuryer kuryer = new Kuryer(++GlobalData.kuryerId, name, surname,"Moto","10-ZZ-010" ,true);
                GlobalData.kuryers.add(kuryer);

                adminMenu(admin);
                break;
            case 3:
                Order searchedOrder;
                if (GlobalData.orders.size()>0) {

                    for (int i = 0; i < GlobalData.orders.size(); i++) {
                        searchedOrder = GlobalData.orders.get(i);
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH':'mm");
                        List<Pizza> pizzaList = new ArrayList<>();

                        LocalDateTime start = searchedOrder.getStartTime();
                        LocalDateTime finish = searchedOrder.getDeliveryTime();
                        Duration duration = Duration.between(LocalDateTime.now(), finish);

                        long l = duration.getSeconds();
                        long minutes = l / 60;

                        if (!searchedOrder.getSousList().isEmpty()) {
                            System.out.println("[" + searchedOrder.getId() + "].Order" + "." + searchedOrder.getPizza() + "\n" + "Location :" + searchedOrder.getDeliveryLocation() + "\n" +
                                    "Order Start Date :" + formatter.format(searchedOrder.getStartTime()) + "\n" +
                                    "Order Delivery Date :" + formatter.format(searchedOrder.getDeliveryTime()) + "\n" +
                                    "Amount Paid :" + searchedOrder.getOrderAmount().doubleValue() + "$\n" +
                                    "Souses : " + searchedOrder.getSousList() + "\n" +
                                    "how much time is left before the order is completed : " + minutes + " minutes\n");
                        } else {
                            System.out.println("[" + searchedOrder.getId() + "].Order" + "." + searchedOrder.getPizza() + "\n" + "Location :" + searchedOrder.getDeliveryLocation() + "\n" +
                                    "Order Start Date :" + formatter.format(searchedOrder.getStartTime()) + "\n" +
                                    "Order Delivery Date :" + formatter.format(searchedOrder.getDeliveryTime()) + "\n" +
                                    "Amount Paid :" + searchedOrder.getOrderAmount().doubleValue() + "$\n" +
                                    "how much time is left before the order is completed : " + minutes + " minutes\n");
                        }
                    }
                }else {
                    System.out.println("Order List is empty!!!\n");
                }
                adminMenu(admin);
                break;
            case 4:
                for (int i = 0; i < GlobalData.kuryers.size(); i++) {
                    System.out.println(GlobalData.kuryers.get(i));
                }
                adminMenu(admin);
                break;
            case 5:
                for (int i = 0; i < GlobalData.customers.size(); i++) {
                    System.out.println(GlobalData.customers.get(i));
                }
                adminMenu(admin);
                break;
            default:
                throw new GlobalException(Exceptions.INVALID_FUNCTION);
        }
    }

    @Override
    public void customerMenu(Customer customer) {
        int option = InputUtil.getInstance().inputInt("[0]->Exit\n" +
                "[1]->Back\n" +
                "[2]->Place Order\n" +
                "[3]->Track Orders\n" +
                "[4]->Cancel Order\n" +
                "Select :");

        List<List<Pizza>> pizzaList = new ArrayList<>();
        List<List<Sous>> sousList = new ArrayList<>();
        BigDecimal totalAmount = new BigDecimal(0);

        switch (option) {
            case 0:
                System.exit(0);
                break;
            case 1:
                menu();
                break;
            case 2:
                List<Object> metodData = pizzaService.selectPizza();

                switch (metodData.size()) {
                    case 2:
                        pizzaList.add((List<Pizza>) metodData.get(0));
                        totalAmount = totalAmount.add((BigDecimal) metodData.get(1));
                        break;
                    case 3:
                        pizzaList.add((List<Pizza>) metodData.get(0));
                        sousList.add((List<Sous>) metodData.get(1));
                        totalAmount = totalAmount.add((BigDecimal) metodData.get(2));
                        break;
                }
                if (!sousList.isEmpty()) {
                    System.out.println("Your order : " + pizzaList + "\n" + sousList + "\n" + "Total Amount :" + totalAmount.doubleValue() + "$");
                } else {
                    System.out.println("Your order : " + pizzaList + "\n" + "Total Amount :" + totalAmount.doubleValue() + "$");
                }

                payment(customer, totalAmount);
                LocalDateTime startDate = LocalDateTime.now();
                LocalDateTime deliveryDate = startDate.plusMinutes(60);

                String adress = InputUtil.getInstance().inputString("where do you want your order to be delivered ? :");

                List<Kuryer> emptyKuryer = new ArrayList<>();

                for (int i = 0; i < GlobalData.kuryers.size(); i++) {
                    if (GlobalData.kuryers.get(i).isEmpty()) {
                        emptyKuryer.add(GlobalData.kuryers.get(i));
                    }
                }
                Random random = new Random();
                int index = random.nextInt(emptyKuryer.size());

                Kuryer kuryer = emptyKuryer.get(index);
                kuryer.setEmpty(false);

                Order order = new Order(customer, kuryer, totalAmount, adress, true, false, startDate, deliveryDate, pizzaList, sousList);

                GlobalData.orders.add(order);

                System.out.println("The Order was accepted successfully ");
                System.out.println(order);

                customerMenu(customer);
                break;
            case 3:
                Order searchedOrder=new Order();
                for (int i = 0; i < GlobalData.orders.size(); i++) {
                    if (GlobalData.orders.get(i).getCustomer()==customer){
                        searchedOrder=GlobalData.orders.get(i);
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH':'mm");
                        LocalDateTime start=searchedOrder.getStartTime();
                        LocalDateTime finish =searchedOrder.getDeliveryTime();
                        Duration duration=Duration.between(LocalDateTime.now(),finish);


                        long l = duration.getSeconds();

                        long minutes=l/60;

                        if (!searchedOrder.getSousList().isEmpty()) {
                            System.out.println("["+searchedOrder.getId()+"].Order"+"."+searchedOrder.getPizza()+"\n"+"Location :"+searchedOrder.getDeliveryLocation()+"\n" +
                                    "Order Start Date :"+formatter.format(searchedOrder.getStartTime())+"\n" +
                                    "Order Delivery Date :"+formatter.format(searchedOrder.getDeliveryTime())+"\n" +
                                    "Amount Paid :"+searchedOrder.getOrderAmount().doubleValue()+"$\n"+
                                    "Souses : "+searchedOrder.getSousList()+"\n"+
                                    "how much time is left before the order is completed : "+minutes+" minutes\n");
                        }else {
                            System.out.println("["+searchedOrder.getId()+"].Order"+"."+searchedOrder.getPizza()+"\n"+"Location :"+searchedOrder.getDeliveryLocation()+"\n" +
                                    "Order Start Date :"+formatter.format(searchedOrder.getStartTime())+"\n" +
                                    "Order Delivery Date :"+formatter.format(searchedOrder.getDeliveryTime())+"\n" +
                                    "Amount Paid :"+searchedOrder.getOrderAmount().doubleValue()+"$\n"+
                                    "how much time is left before the order is completed : "+minutes+" minutes\n");
                        }
                    }else {
                        System.out.println("You Dont have Orders !");
                    }
                }
                customerMenu(customer);
                break;
            case 4:
                menu();
                break;
            default:
                throw new GlobalException(Exceptions.INVALID_FUNCTION);
        }
    }

    @Override
    public void payment(Customer customer,BigDecimal price) {
        System.out.println("---------------Order Payment---------------\n"+
                "Your Capital :"+customer.getCapital().doubleValue()+"$\n" +
                "Amount to be paid :"+price.doubleValue()+"$\n");
        if (customer.getCapital().doubleValue()<price.doubleValue()){
            throw new GlobalException(Exceptions.INSUFFICIENT_FUNDS_EXCEPTION);
        }
        int option=InputUtil.getInstance().inputInt(
                "[1]->Make the payment\n" +
                "[2]->Cancel Order\n" +
                "Select :");
        switch (option){
            case 1:
                    BigDecimal subtract = customer.getCapital().subtract(price);
                    customer.setCapital(subtract);
                    System.out.println("Payment was successful");
                break;
            case 2:
                customerMenu(customer);
                break;
            default:
                throw new GlobalException(Exceptions.INVALID_FUNCTION);
        }
    }
}
