package service.inter;

import model.Customer;

import java.math.BigDecimal;

public interface PaymentService {
    void payment(Customer customer, BigDecimal bigDecimal);
}
