package service.impl;

import enums.Exceptions;
import exceptions.GlobalException;
import global.GlobalData;
import model.Admin;
import model.Kuryer;
import model.Order;
import model.Pizza;
import service.inter.AdminService;
import service.inter.MenuService;
import util.InputUtil;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    static MenuService menuService=new MenuServiceImpl();

    @Override
    public void login() {
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
                 menuService.menu();
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
}
