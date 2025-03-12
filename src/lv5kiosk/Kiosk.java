package lv5kiosk;


import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

// 키오스크는 화면 구성(디스플레이) 과 결제와 입력과 매뉴를 컨트롤 해야합니다.
public class Kiosk {
    private boolean power = false;
    private boolean keepRunning;

    private Menu menu = new Menu();
    private KioskDisplay display = new KioskDisplay();
    private Input input = new Input();
    private Payment payment;

    private int pageNumber = 10;
    private int pageInterval = 10;
    private int totalAmount;

    private int[] selectedNumbers;

    // 카테고리Set 때문에 만든 순서용리스트
    // 중복되는 감이 있는데 일단 넘어갑시다
    private List<String> categoryList = new ArrayList<>();

    // paytype을 관리하기 위한 리스트
    private List<String> payTypeList = new ArrayList<>(Arrays.asList("현금", "카드"));

    public void turnOn() {
        this.power = true;
        System.out.println("======================================");
        System.out.println("키오스크 전원을 켭니다");
    }
    public void turnOff() {
        this.power = false;
        System.out.println("키오스크 전원을 끕니다");
        System.out.println("======================================");
    }

    // 키오스크 시작 매서드 실행하면 반복이다.
    public void start() {
        turnOn();
        setOfTable();
        while (this.power) {
            this.selectedNumbers = new int[100]; // 0으로 채움
            this.keepRunning=false;
            while (!this.keepRunning&&this.power) {
                playKiosk();
            }
        }
    }

    // 사전작업
    public void setOfTable() {
        if (this.menu.getMenuList().isEmpty()) {
            throw new IllegalArgumentException("최초메뉴리스트 자체가 비었습니다");
        }
        this.menu.setCategories(); // 카테고라이즈 카테고리로 채운뒤
        setCategoryList(); // categoryList 에 카테고리 담기
    }

    // 키오스크의 컨트롤
    public void playKiosk() {
        switch (this.pageNumber) {
            case 10: // 시작 화면 입니다. 아무버튼 입력
                this.display.displayOpening(); // 헤더와 본문 보여줌
                this.input.inputNextLine(); // 입력받음
                this.selectedNumbers[10 - 1] = 1; // 일단 받았다는 의미로 1 저장
                this.pageInterval = 10; // 나아가고 돌아올 범위
                this.pageNumber += this.pageInterval; // 다음방
                break;

            case 20: // 두번째 화면 입니다. 카테고리 선택창
                this.display.displayCategory(); // 기본 해더 보여줌
                this.display.displayList(this.categoryList); // 본문 번호+내용들 보여줌
                this.display.exitModal(); // 뒤로가기 종료 모달
                this.input.inputNumber(this.categoryList.size()); // 입력받기 input.number 가 받은 입력번호로 바뀜
                this.selectedNumbers[20 - 1] = this.input.getNumber(); // 그리고 이걸 저장
                this.pageInterval = 10; // 나아가고 돌아올 범위
                this.pageNumber += this.pageInterval; // 다음방
                break;

            case 30: // 세번째 화면입니다. 메뉴 선택창
                this.display.displayMenuItem(); // 기본 헤더 보여줌
                String cName = this.categoryList.get(this.selectedNumbers[20 - 1] - 1);// 선택된 카테고리명이다
                this.menu.setItemsByCategory(cName); // menu의 itemsByCategory를 특정
                displaySelectedMenuList(); // 본문 보여줌
                this.display.exitModal(); // 뒤로가기 종료 모달
                this.input.inputNumber(this.menu.getItemsByCategory().size()); // 번호 입력받기
                this.selectedNumbers[30 - 1] = this.input.getNumber(); // 번호  저장
                this.pageInterval = 5; // 나아가고 돌아올 범위
                this.pageNumber += this.pageInterval; // 다음방
                break;
            case 35: // 세번째 화면 - 개수 입력창
                this.display.displayMenuItemQuantity(); // 기본 헤더 보여줌
                this.display.exitModal(); // 뒤로가기 종료 모달
                this.input.inputQuantity(); // 개수 입력받기
                this.selectedNumbers[35 - 1] = this.input.getNumberQ(); // 개수  저장
                showOrder();
                this.pageInterval = 5; // 나아가고 돌아올 범위
                this.pageNumber += this.pageInterval; // 다음방

            case 40: // 네번째 화면 결제 수단 선택
                this.display.displayPayType(); // 기본 헤더
                this.display.displayList(this.payTypeList); // 결제 수단 보여줌
                this.display.exitModal(); // 뒤로가기 종료 모달
                this.input.inputNumber(this.payTypeList.size());
                this.selectedNumbers[40 - 1] = this.input.getNumber(); // 번호  저장
                this.pageInterval = 5; // 나아가고 돌아올 범위
                this.pageNumber += this.pageInterval; // 다음방
                break;

            case 45: // 네번째 화면 - 선택된 수단에 의한 결제방법
                this.payment = new Payment(this.totalAmount, this.payTypeList.get(this.selectedNumbers[40 - 1] - 1)); // 사전준비
                if (this.selectedNumbers[40 - 1] - 1 == 0) { // 현금의 경우
                    boolean isPaymentSucessful = false;
                    // 총결제금액
                    do {
                        this.display.displayCash(); // 현금입력 기본 헤더
                        this.display.exitModal(); // 뒤로가기 종료 모달
                        this.input.inputInteger(); // 지불 금액 입력 받기
                        isPaymentSucessful = this.payment.process(this.input.getNumberI()); // 지불 완료 여부 T F
                        this.selectedNumbers[45 - 1] = this.payment.getTotalAmountPaid();
                        System.out.println("---------------------------------------");
                        System.out.print(" 투입된 금액 : " + this.payment.getTotalAmountPaid() + " 원 ");
                        if (isPaymentSucessful) {// true냐 false냐
                            // 잔액 받기
                            System.out.println("| 잔돈 " + (this.payment.getTotalAmountPaid() - this.payment.getTotalAmount()) + " 원을 반환합니다");
                            this.pageInterval = 5; // 나아가고 돌아올 범위
                            this.pageNumber += this.pageInterval; // 다음방
                        } else {
                            // 모자란 금액 추가로 받기
                            System.out.println("| 모자란 금액 " + (-1) * (this.payment.getTotalAmountPaid() - this.payment.getTotalAmount()) + " 원");
                        }
                    } while (!isPaymentSucessful);
                } else { // 카드의 경우
                    this.display.displayCard(); // 카드 선택 기본 헤더
                    this.display.displayList(this.payment.getCardList());// 카드 본문 보여주기
                    this.display.exitModal(); // 뒤로가기 종료 모달
                    this.input.inputNumber(this.payment.getCardList().size()); // 번호 입력받기
                    this.selectedNumbers[45 - 1] = this.input.getNumber(); // 선택한 번호 저장
                    boolean isPaymentSucessful = false;
                    isPaymentSucessful = this.payment.process(this.totalAmount); // 카드는 일단 무조건 성공으로, 아주 나중에 카드사와 연계해서 한도초과니 뭐니 하는거는 생각만..
                    String card = this.payment.getCardList().get(selectedNumbers[45 - 1] - 1); // 무슨 카드인지 문자열 반환
                    System.out.println("---------------------------------------");
                    System.out.println("선택한 " + card + "(으)로 결제 완료");
                    this.pageInterval = 5; // 나아가고 돌아올 범위
                    this.pageNumber += this.pageInterval; // 다음방
                }
                break;

            case 50:
                this.pageNumber=10;
                this.display.displayConfirmExit();
                if (this.input.inputExitApp())
                {
                    turnOff();
                } else {
                    this.keepRunning = true;
                }
                break;
            default :
                System.out.println("알수없는오류");
        }
    }


    // 선택한 번호를 list에서 찾아 해당 문자열(카테고리)를 반환
    public String getCategory(int num) {
        return this.categoryList.get(num);
    }

    // 리스트 가지고 보여주는 기능
    // List는 menu 의 itemByCategory 밖에 없다
    // displayList() 매서드는 리스트를 열맞춰 보여주는 것
    public void displaySelectedMenuList() {

        // itemByCategory가 비었으는 예외 (인덱스 접근 못하기때문)
        // 이부분은 종료로 구현합시다 나중에 구현
        if (this.menu.getItemsByCategory().size() == 0) {
            throw new IllegalArgumentException("itemsByCategory가 비었습니다");
        }

        // 정보의 길이를 파악해서 열 맞출 수 있게 하기.
        // menu클래스와 KioskDisplay클래스를 분리시키려(캡슐화) 했기 때문에 둘을 핸들링하는 Kiosk 클래스에서 기능구현
        // 예시) 1.번 | ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
        // 예시) 5.번 | Chickenburger | W 5.4 | Cookin' some chicken! 치킨버거
        int priceLen = 0, nameLen = 0, cateSize = 0, priceLenF = 0, nameLenF = 0;
        cateSize = this.menu.getItemsByCategory().size();
        cateSize = String.valueOf(cateSize).length();
        for (int i = 0; i < this.menu.getItemsByCategory().size(); i++) {
            nameLen = this.menu.getItemsByCategory().get(i).getName().length();
            priceLen = String.valueOf(this.menu.getItemsByCategory().get(i).getPrice()).length();
            if (priceLen > priceLenF) {
                priceLenF = priceLen;
            }
            if (nameLen > nameLenF) {
                nameLenF = nameLen;
            }
        }
        for (int i = 0; i < this.menu.getItemsByCategory().size(); i++) {
            System.out.print(" " + (i + 1) + ".번" + " ".repeat(1 + cateSize - String.valueOf(i).length()));
            System.out.print("| " + this.menu.getItemsByCategory().get(i).getName());
            System.out.print(" ".repeat(1 + nameLenF - this.menu.getItemsByCategory().get(i).getName().length()));
            System.out.print("| W " + this.menu.getItemsByCategory().get(i).getPrice());
            System.out.print(" ".repeat(1 + priceLenF - String.valueOf(this.menu.getItemsByCategory().get(i).getPrice()).length()));
            System.out.println("| " + this.menu.getItemsByCategory().get(i).getDescription());
        }
    }

    public void setCategoryList() {
        if (this.menu.getCategories().isEmpty()) {
            throw new IllegalArgumentException("categories가 비었습니다.");
        }
        // 순서용 리스트에 재배열
        this.categoryList.addAll(this.menu.getCategories());
    }

    // 주문된 정보 출력자
    // 나중에 장바구니가 되면 for문으로 여러줄 표기 해야 함.
    public void showOrder() {
        this.totalAmount = (int) (this.selectedNumbers[35 - 1] * this.menu.getItemsByCategory().get(this.selectedNumbers[30 - 1] - 1).getPrice() * 1000);
        System.out.println("=======================================");
        System.out.print(" 주문내역 : ");
        System.out.print(this.menu.getItemsByCategory().get(this.selectedNumbers[30 - 1] - 1).getName());
        System.out.println(" | " + this.selectedNumbers[35 - 1] + "개");
        System.out.println("    총합 : " + this.totalAmount + " 원");
    }

    // getter
    public Menu getMenu() {
        return this.menu;
    }
    public KioskDisplay getKioskDisplay() {
        return this.display;
    }
    public boolean getPower() {
        return this.power;
    }
    public void setPower() {
        this.power = !this.power;
    }
}
