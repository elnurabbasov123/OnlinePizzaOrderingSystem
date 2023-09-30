package service.impl;

import enums.Exceptions;
import exceptions.GlobalException;
import model.Customer;
import service.inter.CustomerService;
import service.inter.PaymentService;
import util.InputUtil;

import java.math.BigDecimal;

public class PaymentServiceImpl implements PaymentService {

    static CustomerService customerService=new CustomerServiceImpl();

    @Override
    public void payment(Customer customer, BigDecimal price) {
        System.out.println("---------------Order Payment---------------\n"+
                "Your Capital :"+customer.getCapital().doubleValue()+"$\n" +
                "Amount to be paid :"+price.doubleValue()+"$\n");
        if (customer.getCapital().doubleValue()<price.doubleValue()){
            throw new GlobalException(Exceptions.INSUFFICIENT_FUNDS_EXCEPTION);
        }
        int option= InputUtil.getInstance().inputInt(
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
                customerService.customerMenu(customer);
                break;
            default:
                throw new GlobalException(Exceptions.INVALID_FUNCTION);
        }
    }
}
