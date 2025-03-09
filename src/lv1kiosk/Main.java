package lv1kiosk;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Kiosk a = new Kiosk();
//        a.showMenu2("hamburger");
//        a.turnOnkiosk();
        System.out.println(a.menu.getBurger(0).getName());
    }
}
