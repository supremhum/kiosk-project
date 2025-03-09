package lv1kiosk;
import java.math.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Kiosk a = new Kiosk();
        Menu b = new Menu();
//        a.showMenu2("hamburger");
//        a.turnOnkiosk();

        // 6.9
        System.out.println(a.menu.getBurger(0).getPrice());
        // 3
        System.out.println(Double.toString(a.menu.getBurger(0).getPrice()).length());

        b.addBurger(new MenuItem("가",1.1,"다"));
        System.out.println(b.getBurger(0).getName()+""+b.getBurger(4).getName());
    }
}
