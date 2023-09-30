package main;

import global.GlobalData;
import model.Admin;
import model.Customer;

public class Search<T>{
    Object search(T t,int id) {
        if (t instanceof Customer){
            for (int i = 0; i < GlobalData.customers.size(); i++) {
                if (GlobalData.customers.get(i).getId()==id){
                    return GlobalData.customers.get(i);
                }
            }
        }else if(t instanceof Admin){
            for (int i = 0; i < GlobalData.admins.size(); i++) {
                if (GlobalData.admins.get(i).getId()==id){
                    return GlobalData.admins.get(i);
                }
            }
        }
        return "Not Found;";
    }
}
