package lv3kiosk;

import java.util.Scanner;
import java.util.List;
public class Input {
    Scanner scanner = new Scanner(System.in);

    private String firstString="";
    private int number = 0;
    private boolean looping = true;

    // 어떤 객체들이 모아진 집합의 개수를 size라 하자
    private int size;

    // 첫번째 화면 연동
    public void inputString (){
        firstString = scanner.nextLine();
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
                    System.out.println("번호를 다시 입력해 주세요");
                    continue;
                }
                this.looping = false;
            } catch (Exception e) {
                System.out.println("번호를 다시 입력해 주세요");
                this.scanner.nextLine();
            }
        } while (!this.looping);
    }

    // 세번째 화면 - 개수선택
    public void inputQuantity () {
        do {
            try {
                this.number = scanner.nextInt();
                this.scanner.nextLine();
                System.out.println("입력하신 숫자 : "+this.number);
                if (this.number>1000) {
                    System.out.println("현실적으로 1000을 넘지 않는 자연수를 다시 입력해 주세요");
                    continue;
                }
                this.looping = false;
            } catch (Exception e) {
                System.out.println("개수를 다시 입력해 주세요");
                this.scanner.nextLine();
            }
        } while (!this.looping);
    }


    // 이를 switch 문으로 합치자.
    public void inputCase (int number) {
        do {
            try {
                switch (number) {
                    case 1: // 오프닝
                        this.scanner.nextLine();
                        this.looping = false;
                        break;
                    case 2: // 배열의 인덱스+1 받는 입력
                        this.number = this.scanner.nextInt();
                        this.scanner.nextLine();
                        System.out.println("입력하신 번호 : "+this.number);
                        if (this.number<-1||this.number>this.size) {
                            System.out.println("번호를 다시 입력해 주세요");
                            continue;
                        }
                        this.looping = false;
                        break;
                    case 3: // 개수 받는 입력
                        this.number = scanner.nextInt();
                        this.scanner.nextLine();
                        System.out.println("입력하신 숫자 : "+this.number);
                        if (this.number>1000) {
                            System.out.println("현실적으로 1000을 넘지 않는 자연수를 다시 입력해 주세요");
                            continue;
                        }
                        this.looping = false;
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    default :
                        System.out.println("있어선 안돼는 오류구문. 특정케이스는 직접입력이니깐");
                }
                this.number = scanner.nextInt();
                this.scanner.nextLine();
                System.out.println("입력하신 숫자 : "+this.number);
                if (this.number>1000) {
                    System.out.println("현실적으로 1000을 넘지 않는 자연수를 다시 입력해 주세요");
                    continue;
                }
                this.looping = false;
            } catch (Exception e) {
                System.out.println("개수를 다시 입력해 주세요");
                this.scanner.nextLine();
            }
        } while (!this.looping);
        this.looping = true;
    }

    public int getNumber () {
        return this.number;
    }
    public int getSize() {
        return this.size;
    }

    // 이기서 List 만으로 형태를 해도 괜찮은건 다형성때문! 인 것 같다.
    public void setSize(List list) {
        this.size = list.size();
    }


}
