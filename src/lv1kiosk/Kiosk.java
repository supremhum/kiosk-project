package lv1kiosk;

import java.util.Scanner;
public class Kiosk {
    private Scanner scanner = new Scanner(System.in);
    private String category;

    private boolean power = false;

    private Menu menu = new Menu();
    private String[] hamburgerMenu = {"shackburger","smokeshack","cheeseburger","hamburger"};

    public void turnOnkiosk (){
        System.out.println("키오스크 전원을 켭니다");
        this.power = true;
        this.showMenu();
    }

    public void turnOffKiosk() {
        System.out.println("키오스크 전원을 끕니다");
        this.power = false;
        System.exit(0);
    }

    public void showMenu() {
        System.out.print("카테고리를 적어주세요 : ");
        category = scanner.nextLine();
        if (category.equals("hamburger") == true) {
            for (String item:hamburgerMenu) {
                String name = menu.getItem(item).getName();
                double price = menu.getItem(item).getPrice();
                String description = menu.getItem(item).getDescription();
                System.out.println("===================");
                System.out.println("name+"+item+"="+name);
                System.out.println("price+"+item+"="+price);
                System.out.println("description+"+item+"="+description);
                System.out.println("===================");
            }
        }
        else {
            System.out.println("존재하지 않는 카테고리입니다 지금은 hamburger 만 가능");
            this.showMenu();
        }
    }
}

