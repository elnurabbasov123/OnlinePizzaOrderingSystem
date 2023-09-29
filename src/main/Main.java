package main;

import service.impl.ManageServiceImpl;
import service.inter.ManageService;

public class Main {
    static ManageService service=new ManageServiceImpl();

    public static void main(String[] args) {
        service.manage();
    }
}
