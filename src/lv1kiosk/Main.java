package lv1kiosk;
//import java.math.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();

        kiosk.turnOn();
        while (kiosk.power) {
            kiosk.showCategory();
            kiosk.showMenu();
            kiosk.selectMenuItem();
            kiosk.processOrder();
        }

    }
}
