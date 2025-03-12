package lv5kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;


// 키오스크의 화면 구성만을 위한 클래스 입니다.
public class KioskDisplay {

    // 시작화면 처음에 주문하기 누르기 #주문하기누르기창(화면은 광고) [- #포장or매장(<property)창{취소하기}]
    // 카테고리선택창{돌아가기}
    // 해당 카테고리 관련 메뉴들 쭉 나옴 번호입력{돌아가기, 처음으로}
    // 몇개를 주문 {돌아가기,처음으로}
    // 해당 메뉴를 몇개 주문합니다. 결제를 진행하려면 다음을 입력 [돌아가기, 처음으로}
    // 금액을 입력 {돌아가기,처음으로}

    // 첫번째 화면 1
    public void displayOpening() {
        System.out.println("=======================================");
        System.out.println("  첫번째 화면");
        System.out.print(" 주문하시려면 아무키나 입력해 주세요 : ");
    }

    // 두번째 화면 2
    public void displayCategory() {
        System.out.println("=======================================");
        System.out.println("  두번째 화면");
        System.out.println(" 주문하려는 그룹을 선택해 주세요\n");
    }

    // 세번째 화면 3
    public void displayMenuItem() {
        System.out.println("=======================================");
        System.out.println("  세번째 화면\n");
        System.out.println(" 주문하실 메뉴을 선택해 주세요\n");
    }

    // 세번째 화면 - 개수 입력 31
    public void displayMenuItemQuantity() {
        System.out.println("---------------------------------------");
        System.out.println("  세번째 화면 - 개수 입력\n");
        System.out.println(" 주문할 개수를 입력해 주세요");
    }

    // 네번째 화면 4
    public void displayPayType() {
        System.out.println("=======================================");
        System.out.println("  네번째 화면\n");
        System.out.println(" 결제수단을 선택해 주세요");
    }

    // 네번째 화면 - 현금 입력 41
    public void displayCash() {
        System.out.println("---------------------------------------");
        System.out.println("  네번째 화면 - 현금 입력\n");
        System.out.println(" 금액을 투입해 주세요");
    }

    // 네번째 화면 - 카드 42
    public void displayCard() {
        System.out.println("---------------------------------------");
        System.out.println("  네번째 화면 - 카드 입력\n");
        System.out.println(" 카드 종류 번호를 입력해 주세요");
    }

    // 다섯번째 화면 <<< 여기는 따로 놀아야 함 5
    public void displayConfirmExit() {
        System.out.println("=======================================");
        System.out.println("  다섯번째 화면\n");
        // --- 종료, 계속하기 보여주기 ---

        System.out.println(" exit 를 입력하면 종료합니다");
        System.out.println("그 외엔 키오스크를 다시 시작합니다");
        System.out.print("입력 : ");
    }

    // 되돌아가기를 아직은 구현 안한 상태에서 진행해 봅시다.
    public void exitModal() {
        System.out.println("- - - - - - - - - - - - - - - - - - - -");
        System.out.println(" -1. 되돌아 가기 | 0. 종료\n");
        System.out.print("숫자를 입력 : ");
    }

    // 리스트 가지고 보여주는 기능
    // displayList() 매서드는 리스트를 열맞춰 보여주는 것
    public void displayList(List list) {
        // 인덱스 순서로 1번부터 번호를 매겨 show함
        for (int i = 0 ;i<list.size();i++){
            System.out.print(" "+(i+1)+".번 "+list.get(i)+" ");
        }
        System.out.println("");
    }

}

