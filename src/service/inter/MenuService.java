package service.inter;

import model.Admin;
import model.Customer;

import java.math.BigDecimal;

public interface MenuService {
    int menu();
    void adminMenu(Admin admin);
    void customerMenu(Customer customer);
    void payment(Customer customer, BigDecimal price);
}
