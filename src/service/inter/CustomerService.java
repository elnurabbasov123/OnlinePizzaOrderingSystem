package service.inter;

import model.Customer;

public interface CustomerService {
    void customerLogin();
    void customerMenu(Customer customer);
    Customer fillCustomer();
}
