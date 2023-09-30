package main;

import model.Admin;

public class Test {
    public static void main(String[] args) {
        Search<Admin> adminSearch=new Search<>();
        Object search = adminSearch.search(new Admin(), 1);

        System.out.println(search);
    }
}
