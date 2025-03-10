//package lv1kiosk;
//import java.util.Scanner;
//public class Prac {
//    private String[] categorySet = {"burgerSet", "temp1", "temp2"};
//    Scanner scanner = new Scanner(System.in);
//    private int userChoice;
//
//    // 카테고리 보여주면서 선택까지
//    public void showCategory() {
//        String category = "";
//        boolean categoryCheck=false;
//        while (!categoryCheck) {
//            System.out.println("======================================");
//            System.out.println("선택 가능한 카테고리 : " + categorySet[0]);
//            System.out.print("카테고리를 적어주세요 : ");
//            category = scanner.nextLine();
//            if (category.equals(categorySet[0])) {
//                categoryCheck = true;
//            } else {
//                System.out.println("존재하지 않는 카테고리입니다 지금은 hamburger 만 가능");
//            }
//        }
//    }
//
//    // 해당 카테고리 메뉴 보여주기 와 종료도 보여주기
//    public void showMenu() {
//        for (int i = 0; i < menu.getBurgerSetSize(); i++) {
//            String name = menu.getBurger(i).getName();
//            double price = menu.getBurger(i).getPrice();
//            String description = menu.getBurger(i).getDescription();
//            System.out.println("======================================");
//            System.out.println(" " + (i + 1) + "번.");
//            System.out.println("이름 : " + name);
//            System.out.println("가격 : " + price);
//            System.out.println("설명 : " + description);
//        }
//        System.out.println("======================================");
//        System.out.println(" 0번.");
//        System.out.println("종료 : exit");
//        System.out.println("======================================");
//    }
//
//    public void selectMenuItem() {
//        boolean numberCheck = false;
//        while (numberCheck)
//        try {
//            System.out.print("주문하실 번호를 입력해 주세요 : ");
//            this.userChoice = scanner.nextInt();
//            if (this.userChoice<0||this.userChoice>this.menu.getBurgerSetSize()) {
//                System.out.print("번호를 다시 입력해 주세요");
//            } else {
//                numberCheck=true;
//                scanner.nextLine();
//            }
//        } catch (Exception e) {
//            System.out.print("번호를 다시 입력해 주세요");
//            scanner.nextLine();
//        }
//    }
//
//    // 선택 0 종료인경우
//    // 선택 n 버거선택인 경우
//
//
//
//            if (category.equals("hamburger")) {
//                for (int i = 0; i < menu.getBurgerSetSize(); i++) {
//                    String name = menu.getBurger(i).getName();
//                    double price = menu.getBurger(i).getPrice();
//                    String description = menu.getBurger(i).getDescription();
//                    System.out.println("======================================");
//                    System.out.println(" " + (i + 1) + "번.");
//                    System.out.println("이름 : " + name);
//                    System.out.println("가격 : " + price);
//                    System.out.println("설명 : " + description);
//                }
//                break;
//            } else {
//
//            }
//        }
//        System.out.println("======================================");
//        System.out.println(" 0번.");
//        System.out.println("종료 : exit");
//        System.out.println("======================================");
//        // 여기 까지 분리 시점.
//
//    }
//}
