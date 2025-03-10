package lv1kiosk;

public class Menu {

    // 햄버거 카테고리를 위해 burgerSet 이라는 MenuItem 배열 생성
    private MenuItem[] burgerSet = {
            new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
            new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
            new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
            new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거")
    };

    // 나중을 위한 카테고리 추가
    private MenuItem[] temp1 = {};
    private MenuItem[] temp2 = {};

//     method
    // burgerSet 배열에서 index번째 햄버거 인스턴스 가져오기
    public MenuItem getBurger(int index) {
        return this.burgerSet[index];
    }

    // burgerSet 배열에서 새로운 햄버거 인스턴스 추가
    public void addBurger(MenuItem burger) {
        MenuItem[] tempSet = this.burgerSet;
        this.burgerSet = new MenuItem[burgerSet.length+1];
        for (int i = 0 ;i<this.burgerSet.length-1;i++){
            this.burgerSet[i]=tempSet[i];
        }
        this.burgerSet[burgerSet.length-1] = burger;
    }

    // 햄버거 카테고리 원소 개수 세기
    public int getBurgerSetSize() {
        return this.burgerSet.length;
    }

    // temp1 카테고리의 getter
    public MenuItem getTemp1(int index) {
        return this.temp1[index];
    }

    // temp2 카테고리의 getter
    public MenuItem getTemp2(int index) {
        return this.temp2[index];
    }
}
