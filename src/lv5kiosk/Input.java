package lv5kiosk;

import com.sun.jdi.event.ExceptionEvent;

import java.util.List;
import java.util.Scanner;
public class Input {
    private Scanner scanner = new Scanner(System.in);

    private String temp;


    private int number = 0; // 번호가 저장되는 필드
    private int numberQ = 0; // quantity 가 저장되는 필드
    private int numberI = 0; // 정수가 저장되는 필드

    // 어떤 객체들이 모아진 집합의 개수를 size라 하자
    private int size;

    // 첫번째 화면 연동
    public void inputNextLine (){
        this.temp = scanner.nextLine();
    }

    // 두번째 화면 연동 + 세번째화면. 결국 특정 셋에서 번호선택하기와 같다.
    // 번호를 입력받는 것이라서 숫자들 이 중요하긴 한데 얘는 키오스크디스플레이에서 컨트롤이잖아
    // 시작과 동시에 객체들을 생성하고 끝나고 다시시작하면 새로운 객체를 생성해야 하는데
    // 메뉴라는 객체는 고정이야. 내부에서 추가해 주지 않는 이상.
    // 디스플레이도 고정인데
    // 매번 새로운 객체는 장바구니와 연관되어 있어. 따라서 그건 그렇게 하면 된다.
    public void inputNumber (int numb) {// 리스트의 원소를 번호로 1:1 대응 시키기 위함.numb는 원소개수
        this.number=-2;
        do {
            try {
                this.number = scanner.nextInt();
//                this.number = scanner.nextInt();
                this.scanner.nextLine();
                System.out.println("입력하신 번호 : "+this.number);

                // 예외처리
                if (this.number<-1||this.number>numb) {
                    System.out.print("번호를 다시 입력해 주세요 : ");
                }
            } catch (Exception e) {
                System.out.print("예외발생1. 번호를 다시 입력해 주세요 : ");
                this.scanner.nextLine();
            }
        } while (this.number<-1||this.number>numb);
    }

    // 세번째 화면 - 개수선택
    public void inputQuantity () {
        this.numberQ=-2;
        do {
            try {
                this.numberQ = scanner.nextInt();
                this.scanner.nextLine();
                System.out.println("입력하신 숫자 : "+this.numberQ);

                // 예외처리
                if (this.numberQ>300||this.numberQ<-1) {
                    System.out.println("300개를 넘는 주문은 받지 않습니다");
                    System.out.print("개수를 다시 입력해 주세요 : ");
                }
            } catch (Exception e) {
                System.out.print("예외2 개수를 다시 입력해 주세요 : ");
                this.scanner.nextLine();
            }
        } while ((this.numberQ>300||this.numberQ<-1));
    }

    // 일반적인 int 범위 숫자를 입력받기. 주문 개수가 1000 이하니깐 int 범위면 충분. 특이점 가격도 맞춰놨음
    public void inputInteger () {
        this.numberI=-2;
        do {
            try {
                this.numberI = scanner.nextInt();
                this.scanner.nextLine();
                System.out.println("입력하신 숫자 : "+this.numberI);
                // 예외처리
                if (this.numberI<-1||this.numberI>1_000_000_000) {
                    System.out.println("10억 까지만 입력받습니다");
                    System.out.print("숫자를 다시 입력해 주세요 : ");
                }
            } catch (Exception e) {
                System.out.print("예외3 숫자를 다시 입력해 주세요 : ");
                this.scanner.nextLine();
            }
        } while (this.numberI<-1||this.numberI>1000000000);
    }

    public int getNumber () {
        return this.number;
    }
    public int getNumberQ () {
        return this.numberQ;
    }
    public int getNumberI () {
        return this.numberI;
    }

    // 이기서 List 만으로 형태를 해도 괜찮은건 다형성때문! 인 것 같다.
    public void setSize(List list) {
        this.size = list.size();
    }

    public boolean inputExitApp () {
        if (scanner.nextLine().equals("exit")){
            return true;
        } else {
            return false;
        }
    }

    public String getTemp() {
        return this.temp;
    }
}
