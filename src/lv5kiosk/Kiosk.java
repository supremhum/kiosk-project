package lv5kiosk;


import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

// 키오스크는 화면 구성(디스플레이) 과 매뉴를 컨트롤 해야합니다.
public class Kiosk {
    private boolean power = false;
    private Menu menu = new Menu();
    private KioskDisplay display = new KioskDisplay();
    private Input input = new Input();

    // 일반적인 상황에서의 선택한 번호
    private int selectedNumber = 1;
    private int numberQ = 0;


    // 카테고리Set 때문에 만든 순서용리스트
    // 중복되는 감이 있는데 일단 넘어갑시다
    private List<String> list = new ArrayList<>();

    // paytype을 관리하기 위한 리스트
    private List<String> payTypeList = new ArrayList<>(Arrays.asList(
            "현금","카드"
    ));
    // cardtype을 관리하기 위한 리스트
    private List<String> cardTypeList = new ArrayList<>(Arrays.asList(
            "신용카드","체크카드","교통카드","카드뮴"
    ));

    public void turnOn (){
        this.power = true;
        System.out.println("======================================");
        System.out.println("키오스크 전원을 켭니다");
    }

    // 키오스크 시작 매서드 실행하면 반복이다.
    public void start () {
        turnOn();
        while (this.power) {

            // 시작화면
            this.display.displayOpening(); // 화면띄움
            this.input.inputNextLin(); // 아무입력받음

            // 카테고리 보여주는 화면
            this.display.displayCategory(); // 카테고리 선택할 화면 띄움
            showCategory(); // 카테고리 정리해서 화면 띄움 - menu카테고리 재정리됨 - 이를 통해 kiosk 리스트도 재정리됨
            this.display.exitModal(); // 뒤로,종료 모달
            this.input.setSize(this.list); // 리스트 정보를 통해 입력받을 숫자 범위 조정
            this.input.inputNumber(); // 숫자 입력 받기 - input필드에 숫자 저장됨 number - 예외처린 어느정도(부족)

            // 선택된 카테고리로 해당 메뉴 보여주는 화면
            this.selectedNumber = this.input.getNumber(); // input필드에 저장된 숫자 selecNumb 으로 가져오기
            this.display.displayMenuItem(); // 메뉴 선택할 화면 띄움
            displayList(); // menu클래스 필드에 있는 (selecNumb으로 선택된 카테고리로 정렬한) 리스트 정보를 보여줌
            this.display.exitModal(); // 뒤로,종료 모달
            this.input.setSize(this.menu.getItemsByCategory()); // 리스트 정보를 통해 입력받을 숫자 범위 조정
            this.input.inputNumber(); // 숫자 입력 받기 - input필드에 숫자 저장됨 number - 예외처린 어느정도(부족)

            // 선택된 메뉴의 개수를 입력하는 화면
            this.selectedNumber = this.input.getNumber(); // input필드에 저장된 숫자 selecNumb 으로 가져오기. menu의 itemsByCate리스트의 인덱스에 접근하기 위한 정보 저장
            this.display.displayMenuItemQuantity(); // 개수 입력 화면
            this.display.exitModal(); // 뒤로,종료 모달
            this.input.inputQuantity();// input에서 개수를 입력받기 - 받은 입력은 numbQ에 저장

            // 선택된 메뉴(를 알수있는 주소)가 있고 this.selectedNumber
            // 입력한 개수가 있다 input.numberQ
            // 주문된 정보를 보여주는 한줄 코드 필요하다
            showOrder();

            // 해당 주문에 대한 결제 입력 화면
            this.display.displayPayType(); // 결제수단 선택 화면 - 이또한 지금은 kiosk에서 관리하자 리스트로
            showPayType(); // 결제수단 리스트를 받아 화면에 표기
            this.display.exitModal(); // 뒤로,종료 모달
            this.input.setSize(this.payTypeList); // 결제수단 리스트 정보를 통해 입력받을 숫자 범위 조정
            this.input.inputNumber(); // 숫자 입력 받기 - input필드에 숫자 저장됨 number - 예외처린 어느정도(부족)

            // 지금은 현금(1번) 카드(2번)에 대한 케이스 이지만 일반화 하기 위해선 생각이 필요하다.
            if (this.input.getNumber()-1==0) {
                // 현금인 경우
                this.display.displayCash();// 현금 입력 화면
                this.display.exitModal(); // 뒤로,종료 모달
                do {
                    this.input.inputInteger(); // 금액입력받기. numberI 에 저장됨
                    if ((this.input.getNumberQ()
                            * this.menu.getItemsByCategory().get(this.selectedNumber - 1).getPrice()
                            *1000)
                            > this.input.getNumberI()) {
                        System.out.println("금액이 부족합니다");
                        System.out.print("다시 입력해 주세요 : ");
                    } else {
                        System.out.println("잔액 "+(int)(this.input.getNumberI()
                                -
                                (this.input.getNumberQ()
                                        * this.menu.getItemsByCategory().get(this.selectedNumber - 1).getPrice())
                                        *1000)+"원 을 받아가 주세요.");
                    }
                } while ((this.input.getNumberQ()*this.menu.getItemsByCategory().get(this.selectedNumber-1).getPrice()*1000)>this.input.getNumberI());
            } else {
                // 카드인 경우
                this.display.displayCard(); // 카드 결제 화면 표시
                showCardType();
                this.display.exitModal(); // 뒤로,종료 모달
                this.input.setSize(this.cardTypeList); // 리스트 정보를 통해 입력받을 숫자 범위 조정
                this.input.inputNumber(); // 카드 타입을 결정했다.
                System.out.println(this.cardTypeList.get(input.getNumber()-1)+" (으)로 결제를 완료했습니다.");

            }

            this.display.displayConfirmExit();
            this.power = this.input.inputExitApp();
        }
    }

    // getter
    // 1.카테고리를 보여줘야 하는데 그 매서드가 실행되는 순간
    // 2.setCategories() 실행하고
    // 3.위의 원소들 리스트에 담아줌
    // 4.그 리스트를 보여줘야해
    // 그리고 입력받겠지 그 번호를 가지고
    // setItemsByCategory(리스트.get(번호)) 하는것까지
    //1~4까지 함. 입력받음은 input으로 넘기고 여기에 이제 항상 뒤로와 종료 눌러야함
    public void showCategory(){

        // menu클래스의 categories를 정리
        menu.setCategories();

        // categories 가 비어있는 예외처리
        if (menu.getCategories().size()==0) {
            System.out.println("카테고리를 찾을 수 없습니다");
            return;
        }
        // Kiosk의 List도 클리어 한번 해야된다. 이거 안해서 트러블 슈팅 발생
        this.list.removeAll(this.list);

        // 순서용 리스트에 재배열
        for (String cate:menu.getCategories()){
            this.list.add(cate);
        }
        // 인덱스 순서로 1번부터 번호를 매겨 show함
        for (int i = 0 ;i<this.list.size();i++){
            System.out.print(" "+(i+1)+".번 "+this.list.get(i)+" ");
        }
        System.out.println("");
    }

    // 선택한 번호를 list에서 찾아 해당 문자열(카테고리)를 반환
    public String getCategory(){
        return this.list.get(this.selectedNumber-1);
    }

    // 리스트 가지고 보여주는 기능
    // List는 menu 의 itemByCategory 밖에 없다
    // displayList() 매서드는 리스트를 열맞춰 보여주는 것
    public void displayList() {

        // menu클래스의 itemsByCategory를 입력받은 정보에 의해 정리
        menu.setItemsByCategory(this.list.get(this.selectedNumber-1));

        // itemByCategory가 비었으는 예외 (인덱스 접근 못하기때문)
        // 이부분은 종료로 구현합시다 나중에 구현
        if (this.menu.getItemsByCategory().size() == 0) {
            System.out.println("리스트가 비어있어 실행 할 수 없습니다");
            return;
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
            if (priceLen>priceLenF) {priceLenF=priceLen;}
            if (nameLen>nameLenF) {nameLenF=nameLen;}
        }
        for (int i = 0;i<this.menu.getItemsByCategory().size();i++) {
            System.out.print(" " + (i+1) + ".번" + " ".repeat(1 + cateSize - String.valueOf(i).length()));
            System.out.print("| " + this.menu.getItemsByCategory().get(i).getName());
            System.out.print(" ".repeat(1 + nameLenF - this.menu.getItemsByCategory().get(i).getName().length()));
            System.out.print("| W " + this.menu.getItemsByCategory().get(i).getPrice());
            System.out.print(" ".repeat(1 + priceLenF - String.valueOf(this.menu.getItemsByCategory().get(i).getPrice()).length()));
            System.out.println("| " + this.menu.getItemsByCategory().get(i).getDescription());
        }
    }

    // 선택된 메뉴(를 알수있는 주소)가 있고 this.selectedNumber
    // 입력한 개수가 있다 input.numberQ
    // 주문된 정보를 보여주는 한줄 코드 필요하다
    // 나중에 장바구니가 되면 for문으로 여러줄 표기 해야 함.
    public void showOrder () {
        System.out.println("=======================================");
        System.out.print(" 주문내역 : ");
        System.out.print(this.menu.getItemsByCategory().get(this.selectedNumber-1).getName());
        System.out.println(" | "+this.input.getNumberQ()+"개");
        System.out.println("    총합 : "+(int)(this.input.getNumberQ()*this.menu.getItemsByCategory().get(this.selectedNumber-1).getPrice()*1000)+" 원");
    }

    public void showPayType() {
        if (this.payTypeList.size()==0) {
            System.out.println("결제수단 리스트가 비었습니다 종료합니다");
            System.exit(0);
        } else {
            for (int i = 0 ;i<this.payTypeList.size();i++){
                System.out.print(" "+(i+1)+".번 "+this.payTypeList.get(i)+" ");
            }
            System.out.println("");
        }
    }
    public void showCardType() {
        if (this.cardTypeList.size()==0) {
            System.out.println("카드타입 리스트가 비었습니다 종료합니다");
            System.exit(0);
        } else {
            for (int i = 0 ;i<this.cardTypeList.size();i++){
                System.out.print(" "+(i+1)+".번 "+this.cardTypeList.get(i)+" ");
            }
            System.out.println("");
        }
    }


    // getter
    public Menu getMenu () {
        return this.menu;
    }
    public KioskDisplay getKioskDisplay() {
        return this.display;
    }

}

