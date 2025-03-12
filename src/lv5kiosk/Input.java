package lv5kiosk;

import java.util.List;
import java.util.Scanner;
public class Input {
    private Scanner scanner = new Scanner(System.in);

    private String firstString="";
    private int number = 0;
    private int numberQ = 0;
    private int numberI = 0;
    private boolean looping = true;

    // 현재 몇번 위치인지 저장
    private int beforeRoom = 0;
    private int thisRoom = 0;
    private int afterRoom = 1;

    // 어떤 객체들이 모아진 집합의 개수를 size라 하자
    private int size;

    // 첫번째 화면 연동
    public void inputNextLin (){
        scanner.nextLine();
    }

    // 두번째 화면 연동 + 세번째화면. 결국 특정 셋에서 번호선택하기와 같다.
    // 번호를 입력받는 것이라서 숫자들 이 중요하긴 한데 얘는 키오스크디스플레이에서 컨트롤이잖아
    // 시작과 동시에 객체들을 생성하고 끝나고 다시시작하면 새로운 객체를 생성해야 하는데
    // 메뉴라는 객체는 고정이야. 내부에서 추가해 주지 않는 이상.
    // 디스플레이도 고정인데
    // 매번 새로운 객체는 장바구니와 연관되어 있어. 따라서 그건 그렇게 하면 된다.
    public void inputNumber () {
        do {
            try {
                this.number = scanner.nextInt();
                this.scanner.nextLine();
                System.out.println("입력하신 번호 : "+this.number);
                if (this.number<-1||this.number>this.size) {
                    System.out.print("번호를 다시 입력해 주세요 : ");
                } else if (this.number==-1) {
                    System.out.println("구현안함");
                    System.exit(0);
                } else if (this.number==0) {
                    System.out.println("종료합니다");
                    System.exit(0);
                }
            } catch (Exception e) {
                System.out.print("예외발생1. 번호를 다시 입력해 주세요 : ");
                this.scanner.nextLine();
            }
        } while ((this.number<-1||this.number>this.size));
    }

    // 세번째 화면 - 개수선택
    public void inputQuantity () {
        do {
            try {
                this.numberQ = scanner.nextInt();
                this.scanner.nextLine();
                System.out.println("입력하신 숫자 : "+this.numberQ);

                // 예외처리
                if (this.numberQ>1000||this.numberQ<-1) {
                    System.out.println("행여 1000개를 넘는 주문은 받지 않습니다");
                    System.out.print("개수 혹은 번호를 다시 입력해 주세요 : ");
                } else if (this.numberQ==-1) {
                    System.out.println("구현안함");
                    System.exit(0);
                } else if (this.numberQ==0) {
                    System.out.println("종료합니다");
                    System.exit(0);
                }
            } catch (Exception e) {
                System.out.print("개수를 다시 입력해 주세요 : ");
                this.scanner.nextLine();
            }
        } while ((this.numberQ>1000||this.numberQ<-1));
    }

    // 일반적인 int 범위 숫자를 입력받기. 주문 개수가 1000 이하니깐 int 범위면 충분. 특이점 가격도 맞춰놨음
    public void inputInteger () {
        do {
            try {
                this.numberI = scanner.nextInt();
                this.scanner.nextLine();
                System.out.println("입력하신 숫자 : "+this.numberI);

                // 예외처리
                if (this.numberI<-1) {
                    System.out.print("숫자를 다시 입력해 주세요 : ");
                } else if (this.numberI==-1) {
                    System.out.println("구현안함");
                    System.exit(0);
                } else if (this.numberI==0) {
                    System.out.println("종료합니다");
                    System.exit(0);
                }
            } catch (Exception e) {
                System.out.print("숫자를 다시 입력해 주세요 : ");
                this.scanner.nextLine();
            }
        } while (this.numberI<-1);
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
            return false;
        } else {
            return true;
        }
    }
}
