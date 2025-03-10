package lv2kiosk;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Menu {

    // List 는 ArrayList의 인터페이스다. 따라서 참조형 타입으로 List를 쓰며
    // ArrayList 의 원소를 한방에 초기화 할 수 있는 방법이 딱히 없어서 검색한결과
    // Arrays.asList 로 고정배열을 만들어서 ArrayList로 감싸면 된다고 함.
    // 내부적으로 작동하는 원리는 봐도 아직 잘 이해가 안가긴 함.
        private final List<MenuItem> burgerList = new ArrayList<>(Arrays.asList(
            new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
            new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
            new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
            new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거")
    ));

    // burgerList 배열에서 index번째 햄버거 인스턴스 가져오기가 필요없다. 가져오는건 property 즉 List자체만이니깐.
    // 따라서 getter 하나면 되고 final을 붙였기 때문에 setter도 필요 업다.
    public List<MenuItem> getBurgerList () {
        return this.burgerList;
    }

}
