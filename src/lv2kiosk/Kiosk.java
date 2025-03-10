package lv2kiosk;


import java.util.Scanner;
public class Kiosk {
    private Scanner scanner = new Scanner(System.in);
    private int userChoice;

    public boolean power = false;

    private Menu menu = new Menu();
    private String[] categorySet = {"burgerSet","temp1","temp2"};



    public void turnOn (){
        System.out.println("======================================\n");
        System.out.println("키오스크 전원을 켭니다\n");
        this.power = true;
    }

    public void turnOff() {
        System.out.println("키오스크 전원을 끕니다");
        this.power = false;
        System.exit(0);
    }

    // 카테고리 보여주면서 선택까지
    public void showCategory() {
        String category = "";
        boolean categoryCheck=false;
        while (!categoryCheck) {
            System.out.println("======================================");
            System.out.println("선택 가능한 카테고리 : " + categorySet[0]);
            System.out.print("카테고리를 적어주세요 : ");
            category = scanner.nextLine();
            if (category.equals(categorySet[0])) {
                categoryCheck = true;
            } else {
                System.out.println("존재하지 않는 카테고리입니다 지금은 burgerSet 만 가능");
            }
        }
    }

    // 해당 카테고리 메뉴 보여주기 와 종료도 보여주기
    public void showMenu() {
        for (int i = 0; i < menu.getBurgerList().size(); i++) {
            String name = menu.getBurgerList().get(i).getName();
            double price = menu.getBurgerList().get(i).getPrice();
            String description = menu.getBurgerList().get(i).getDescription();
            System.out.println("======================================");
            System.out.println(" " + (i + 1) + "번.");
            System.out.println("이름 : " + name);
            System.out.println("가격 : " + price);
            System.out.println("설명 : " + description);
        }
        System.out.println("======================================");
        System.out.println(" 0번.");
        System.out.println("종료 : exit");
        System.out.println("======================================");
    }

    //장바구니 구현 나중에
    public void selectMenuItem() {
        boolean numberCheck = false;
        while (!numberCheck) {
            try {
                System.out.print("주문하실 번호를 입력해 주세요 : ");
                this.userChoice = scanner.nextInt();
                if (this.userChoice==0){
                    this.turnOff();
                }
                else if (this.userChoice < 0 || this.userChoice > this.menu.getBurgerList().size()) {
                    System.out.println("번호를 다시 입력해 주세요");
                } else {
                    numberCheck = true;
                    scanner.nextLine();
                }
            } catch (Exception e) {
                System.out.println("번호를 다시 입력해 주세요");
                scanner.nextLine();
            }
        }
    }

    // 금액 연속으로 추가하는거 나중에 구현
    public void processOrder (){
        System.out.println("주문하신 메뉴는 "+menu.getBurgerList().get(this.userChoice-1).getName()+" : "+menu.getBurgerList().get(this.userChoice-1).getDescription()+" 입니다");
        System.out.println("가격은 "+Math.round(menu.getBurgerList().get(this.userChoice-1).getPrice()*1000)+" 원 입니다");
        int amount=0;
        do {
            try {
                System.out.print("금액을 입력해 주세요 : ");
                amount = scanner.nextInt();
                if (amount>=(Math.round(menu.getBurgerList().get(this.userChoice-1).getPrice()*1000))){
                    System.out.println((amount-Math.round(menu.getBurgerList().get(this.userChoice-1).getPrice()*1000))+" 원을 반환합니다");
//                    this.turnOff();
                    scanner.nextLine();
                } else {
                    System.out.println("금액이 부족합니다");
                }
            } catch (Exception e) {
                System.out.println("알 수 없는 오류");
                scanner.nextLine();
            }
        } while (amount<(Math.round(menu.getBurgerList().get(this.userChoice-1).getPrice()*1000)));
    }

}

