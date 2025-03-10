package lv3kiosk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Menu {

    // 햄버거 객체들을 모아둔 리스트.
    // 메뉴를 메뉴판이라 생각하면 음식 객체들은 여기에 있는게 맞다고 생각
        private List<MenuItem> burgerList = new ArrayList<>(Arrays.asList(
            new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거","burger"),
            new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거","burger"),
            new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거","burger"),
            new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거","burger")
    ));

    // 지금 속성이 List 하나기 때문에 getter 는 하나면 되고 final을 붙였기 때문에 setter도 필요 업다.
    public List<MenuItem> getBurgerList () {
        return this.burgerList;
    }

    // 나중에 계획은 burgerList 라는 변수명을 MenuItemList 라는 일반적인 네이밍으로 바꾸고
    // List에 모든 메뉴를 다 생성해두는데, 카테고리별로 구분하기 위해 추가속성을 MenuItem 에서 할것이다.
    // 그렇게 되면 햄버거만 들어가는 리스트 getter 와 음료수만 들어가는 리스트 getter 등을 만들어야 한다.
}
