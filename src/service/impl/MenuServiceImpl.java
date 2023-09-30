package service.impl;
import enums.Exceptions;
import exceptions.GlobalException;
import model.*;
import service.inter.*;
import util.InputUtil;

public class MenuServiceImpl implements MenuService {
    static PizzaService pizzaService=new PizzaServiceImpl();
    static KuryerService kuryerService=new KuryerServiceImpl();
    static CustomerService customerService=new CustomerServiceImpl();
    static AdminService adminService=new AdminServiceImpl();

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
                adminService.login();
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
                        customerService.customerLogin();
                        break;
                    case 2:
                        Customer customer = customerService.fillCustomer();
                        customerService.customerMenu(customer);
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
}
