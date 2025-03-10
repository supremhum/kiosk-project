package lv2kiosk;
//import java.math.*;

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
