package service.impl;

import global.GlobalData;
import model.Pizza;
import model.Sous;
import service.inter.PizzaService;
import util.InputUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PizzaServiceImpl implements PizzaService {
    @Override
    public List<Object> selectPizza() {
        System.out.println("------------------------------MENYU------------------------------\n"+
                "[1]->Italiano : Small=4.99 , Medium=7.99 , Large=11.99\n" +
                "[2]->Americano : Small=5.99, Medium=8.99 , Large=12.99\n" +
                "[3]->Mexicano : Small=4.69 , Medium=7.59 , Large=13.49\n"+
                "[4]->Chicken Kickers : Small=5.10 , Medium=8.29 , Large=13.39\n"+
                "[5]->Margherita : Small=4.89 , Medium=8.99 , Large=14.20\n"+
                "[6]->Pepperoni : Small=4.99, Medium=8.29 , Large=16.99\n");

        int count = InputUtil.getInstance().inputInt("How many pizza do you want to order ? :");

        List<Pizza> pizzaList=new ArrayList<>();
        String pizzaName="";
        String pizzaSize="";
        Pizza pizza=null;
        List<Object> data=new ArrayList<>();
        List<Sous> sousList=new ArrayList<>();
        BigDecimal totalPrice=new BigDecimal(0);

        for (int i = 0; i < count; i++) {
            int n=i+1;
            int pizzaNum=InputUtil.getInstance().inputInt("Select ["+n+"]. pizza\n"+
                    "[1]->Italiano\n" +
                    "[2]->Americano\n" +
                    "[3]->Mexicano\n"+
                    "[4]->Chicken Kickers\n"+
                    "[5]->Margherita\n"+
                    "[6]->Pepperoni\n" +
                    "Select : ");
            switch (pizzaNum){
                case 1->pizzaName="Italiano";
                case 2->pizzaName="Americano";
                case 3->pizzaName="Mexicano";
                case 4->pizzaName="Chicken Kickers";
                case 5->pizzaName="Margherita";
                case 6->pizzaName="Pepperoni";
            }
            for (int j = 0; j < GlobalData.pizzaList.size(); j++) {
                if (GlobalData.pizzaList.get(j).getName().equals(pizzaName)){
                    pizza=GlobalData.pizzaList.get(j);
                }
            }
            int size = InputUtil.getInstance().inputInt("[1]->Small\n"+
                    "[2]->Medium\n" +
                    "[3]->Large\n" +
                    "Select :");
            switch (size){
                case 1->pizza.setPrice(pizza.getSmallPrice());
                case 2->pizza.setPrice(pizza.getMediumPrice());
                case 3->pizza.setPrice(pizza.getLargePrice());
            }
            switch (size){
                case 1->pizzaSize="Small";
                case 2->pizzaSize="Medium";
                case 3->pizzaSize="Large";
            }
            pizza.setSize(pizzaSize);
            pizzaList.add(pizza);
        }
        for (int i = 0; i < pizzaList.size(); i++) {
            totalPrice=totalPrice.add(pizzaList.get(i).getPrice());
        }
        boolean ok=false;
        int checkSous=InputUtil.getInstance().inputInt("Do You want sous ?\n" +
                "[1]->Yes\n" +
                "[2]->No\n" +
                "Select :");
        switch (checkSous){
            case 1->ok=true;
            case 2->ok=false;
        }
        if (ok){

            String sousname="";

            System.out.println("--------------------Souses--------------------");
            for (int i = 0; i < GlobalData.sousList.size(); i++) {
                int n=i+1;
                System.out.println("["+n+"]."+GlobalData.sousList.get(i));
            }
            int sousCount=InputUtil.getInstance().inputInt("How many sous do You want to order ? :");
            for (int i = 0; i < sousCount; i++) {
                int n=i+1;
                System.out.println("Select ["+n+"]. sous");

                int sousNum=InputUtil.getInstance().inputInt("[1]->Kectup\n" +
                        "[2]->Barbecu\n" +
                        "[3]->Mayonnaise\n" +
                        "Select : ");
                switch (sousNum){
                    case 1->sousname="Ketcup";
                    case 2->sousname="Barbecu";
                    case 3->sousname="Mayonnaise";
                }


                for (int k = 0; k < GlobalData.sousList.size(); k++) {
                    if (GlobalData.sousList.get(k).getName().equals(sousname)){
                        sousList.add(GlobalData.sousList.get(k));
                        totalPrice=totalPrice.add(GlobalData.sousList.get(k).getPrice());
                    }
                }
            }
        }

        if (!ok){
            data.add(pizzaList);
            data.add(totalPrice);
        }else {
            data.add(pizzaList);
            data.add(sousList);
            data.add(totalPrice);
        }
        return data;
    }
}
