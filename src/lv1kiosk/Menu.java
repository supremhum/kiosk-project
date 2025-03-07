package lv1kiosk;

public class Menu {
    // property를 MenuItem 의 생성자로 만들었다.
    private MenuItem shackburger = new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거");
    private MenuItem smokeshack = new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
    private MenuItem cheeseburger = new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
    private MenuItem hamburger = new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거");

    // method
    // 속성 보여주기
    public MenuItem getItem(String name) {
        switch (name) {
            case "shackburger":
                return this.shackburger;
            case "smokeshack":
                return this.smokeshack;
            case "cheeseburger":
                return this.cheeseburger;
            case "hamburger":
                return this.hamburger;
            default :
                return null;
        }
    }
}
