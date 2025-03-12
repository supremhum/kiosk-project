package lv3kiosk;
import java.lang.Thread;
import java.util.Scanner;
import java.util.List;

// 키오스크의 화면 구성만을 위한 클래스 입니다.
public class KioskDisplay {
    // 리스트를 받아와서 이거를 이쁘게 정렬하는 디스플레이를 짜야 한다
    List list;


    boolean looping = true;
    Kiosk kiosk = new Kiosk();
    Scanner scanner = new Scanner(System.in);
    // 시작화면 처음에 주문하기 누르기 #주문하기누르기창(화면은 광고) [- #포장or매장(<property)창{취소하기}]
    // 카테고리선택창{돌아가기}
    // 해당 카테고리 관련 메뉴들 쭉 나옴 번호입력{돌아가기, 처음으로}
    // 몇개를 주문 {돌아가기,처음으로}
    // 해당 메뉴를 몇개 주문합니다. 결제를 진행하려면 다음을 입력 [돌아가기, 처음으로}
    // 금액을 입력 {돌아가기,처음으로}
    // sleep 먹고 시작화면으로 돌아간다.

    // 리스트를 받아와서 이거를 이쁘게 정렬하는 디스플레이를 짜야 한다
    public void displayList () {
        for (int i = 0 ; i<list.size() ;i++)
            System.out.println(" ".repeat(3));
    }




    // 첫번째 화면 1
    public void displayOpening (){
        System.out.println("=======================================");
        System.out.println("  첫번째 화면\n");
        System.out.print(" 주문하시려면 아무키나 입력해 주세요 : ");
    }

    // 두번째 화면 2
    public void displayCategory () {
        System.out.println("=======================================");
        System.out.println("  두번째 화면\n");
        System.out.println(" 주문 하려는 그룹을 선택해 주세요\n");

        // --- 카테고리 보여주는 디스플레이 ---
        /*
        for (int i = 0 ; i<kiosk.getCategorySet().length;i++) {
        System.out.println((i+1)+". 번 "+kiosk.getCategorySet()[i]+"\n");
        }
        */
        exitModal ();//뒤로가기, 종료는 항상 존재 하면서 입력해주세요 : 까지
    }

    // 세번째 화면 3
    public void displayMenuItem () {
        System.out.println("=======================================");
        System.out.println("  세번째 화면\n");
        // --- 메뉴 보여주는 디스플레이 ---
        /*

        */
        exitModal ();//뒤로가기, 종료는 항상 존재 하면서 입력해주세요 : 까지
    }

    // 세번째 화면 - 개수 입력 31
    public void displayMenuItemQuantity () {
        System.out.println("---------------------------------------");
        System.out.println("  세번째 화면 - 개수 입력\n");
        System.out.print(" 주문할 개수를 입력해 주세요");
        exitModal ();//뒤로가기, 종료는 항상 존재
    }

    // 네번째 화면 4
    public void displayPayType () {
        System.out.println("=======================================");
        System.out.println("  네번째 화면\n");
        // --- 결제 수단 보여주는 디스플레이 ---
        /* 1번 현금 2번 카드

        */
        exitModal ();//뒤로가기, 종료는 항상 존재 하면서 입력해주세요 : 까지
    }

    // 네번째 화면 - 현금 입력 41
    public void displayCash () {
        System.out.println("---------------------------------------");
        System.out.println("  네번째 화면 - 현금 입력\n");
        System.out.print(" 지불할 금액을 입력해 주세요");
        // --- 현금 입력 디스플레이 ---
        /*

        */
        exitModal ();//뒤로가기, 종료는 항상 존재
    }

    // 네번째 화면 - 카드 42
    public void displayCard () {
        System.out.println("---------------------------------------");
        System.out.println("  네번째 화면 - 카드 입력\n");
        System.out.print(" 카드 종류 번호를 입력해 주세요");
        // --- 결제 카드 보여주는 디스플레이 ---
        /* 1번 신용카드 2번 체크카드 3번 교통카드 4번 카드뮴

        */
        exitModal ();//뒤로가기, 종료는 항상 존재
    }

    // 다섯번째 화면 <<< 여기는 따로 놀아야 함 5
    public void displayConfirmExit () {
        System.out.println("=======================================");
        System.out.println("  다섯번째 화면\n");
        // --- 종료, 계속하기 보여주기 ---
        /*

        */
        System.out.print(" 번호를 선택해 주세요 : ");
    }

    // 되돌아가기를 아직은 구현 안한 상태에서 진행해 봅시다.
    public void exitModal () {
        System.out.println("- - - - - - - - - - - - - - - - - - - -");
        System.out.println(" -1. 되돌아 가기 | 0. 종료\n");
        System.out.print("숫자를 입력해주세요 : ");
    }

////////////////////////////////////////////////////////////////////////////

    public void exitDisplay (){
        System.out.println("키오스크를 나갑니다");
        do {
            System.out.println("프로그램 종료를 원하면 \"TurnOff\" 를");
            System.out.println("계속해서 주문을 원하면 \" Start \" 를");
            System.out.print("입력해 주세요 : ");
            String text = scanner.next();
            System.out.println("입력 결과 : "+text);
            if (text.equals("TurnOff")) {
                scanner.nextLine();
                kiosk.turnOff();
            } else if (text.equals("Start")) {
                scanner.nextLine();
                looping = false;
                System.out.print("3초 뒤에 시작 화면으로 돌아갑니다");
                try {
                Thread.sleep(3000);
                } catch (Exception e) {
                    System.out.println("수면중 알 수 없는 오류");
                }
            }
        } while (!looping);
    }

    // 되돌아가기를 아직은 구현 안한 상태에서 진행해 봅시다.
    public void exitModal2 (){
        System.out.println("- - - - - - - - - - - - - - - - - - - -");
        System.out.println(" -1. 되돌아 가기 | 0. 종료\n");
        System.out.print("숫자를 입력해주세요 : ");
        try {
            int numb = scanner.nextInt();
            scanner.nextLine();
            if (numb==0) {
                this.exitDisplay ();
            } else if (numb==-1) {
                System.out.println("되돌아 가기는 아직 구현 못했습니다 종료로 대체합니다");
                this.exitDisplay ();
            }
        } catch (Exception e) {
            System.out.print("=======================================");
            System.out.print("알 수 없는 오류. 다시 입력해 주세요");
            scanner.nextLine();
        }

    }


}
