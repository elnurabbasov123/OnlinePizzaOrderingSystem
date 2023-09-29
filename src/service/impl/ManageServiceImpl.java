package service.impl;

import service.inter.ManageService;
import service.inter.MenuService;

public class ManageServiceImpl implements ManageService {
    MenuService menuService=new MenuServiceImpl();

    @Override
    public void manage() {
        while(true){
            menuService.menu();
        }
    }
}
