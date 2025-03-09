package lv1kiosk;

public class Menu {
    // property를 MenuItem 의 생성자로 만들었다.
//    private MenuItem shackburger = new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거");
//    private MenuItem smokeshack = new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
//    private MenuItem cheeseburger = new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
//    private MenuItem hamburger = new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거");

    // 위처럼 하나씩 인스턴스화 하는게 뭔가 이상해서 배열을 생각. 이러면 인스턴스의 변수명이 인덱스처럼 된다.
    public MenuItem[] hamburgerSet = {
            new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
            new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
            new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
            new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거")
    };

    // 나중을 위한 카테고리 추가
    private MenuItem[] temp1 = {};
    private MenuItem[] temp2 = {};

//     method
    // 햄버거 카테고리의 getter
    public MenuItem getBurger(int index) {
        return this.hamburgerSet[index];
    }

    // 카테고리에 햅버거 추가
    public void addBurger(MenuItem burger) {
        MenuItem[] tempSet = this.hamburgerSet;
        int tempInt = hamburgerSet.length;
        this.hamburgerSet = new MenuItem[tempInt+1];
        for (int i = 0 ;i<tempInt;i++){
            this.hamburgerSet[i]=tempSet[i];
        }
        this.hamburgerSet[tempInt] = burger;
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
