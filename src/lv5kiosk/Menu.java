package lv5kiosk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.List;

public class Menu {

    // 햄버거 객체들을 모아둔 리스트.
    // 메뉴를 메뉴판이라 생각하면 음식 객체들은 여기에 있는게 맞다고 생각
        private List<MenuItem> menuList = new ArrayList<>(Arrays.asList(
            new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거","burger"),
            new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거","burger"),
            new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거","burger"),
            new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거","burger"),
            new MenuItem("Chickenburger", 5.4, "Cookin' some chicken! 치킨버거","burger"),
            new MenuItem("Whatdrink", 2.4, "비프패티를 기반으로 야채가 들어간 탄산음료","drink"),
            new MenuItem("Cheesebull", 2149, "소소하게 금박을 입힌 치즈블","side")
    ));
        private HashSet<String> categories = new HashSet<>(Set.of(
                "burger","drink","testCategory"
        ));
        private List<MenuItem> itemsByCategory = new ArrayList<>();

    // 게터 . 간접접근이긴 하지만 직접접근과 거의 같다.
    public List<MenuItem> getMenuList () {
        return this.menuList;
    }
    public HashSet<String> getCategories () {
        return this.categories;
    }
    public List<MenuItem> getItemsByCategory () {
        return this.itemsByCategory;
    }

//
//     특정 기능
//     categoryList와 menuList의 카테고리속성 있는 값 없는 값 비교
//     동시에 set까지. menuList 가 주인공으로 categoryList를 재조정.
//     없으면 채우고, 없는 건 지우고 라고 생각했지만
//     join 같이 될 바에 중복값 없는 HashSet에 그냥 넣으면 되는것!
//     categories를 비운뒤 menuList에만 있는 카테고리로 채운다.
    public void setCategories () {
        if (this.menuList.size()==0){
            System.out.println("menuList가 비어 실행 할 수 없습니다");
            return; // void 에선 return; 만 해주면 끝남
        }
        this.categories.removeAll(this.categories); // 집합 클리어
        for (int i = 0 ; i<this.menuList.size() ; i++) {
            categories.add(this.menuList.get(i).getCategory());
        }
    }

    // itemsByCategory 리스트를 변경 하는 것이니 setter
    // itemsByCategory 에 매개변수와 같은 카테고리의 객체들만 담는다.
    public List<MenuItem> setItemsByCategory(String category){
        this.itemsByCategory.removeAll(this.itemsByCategory);
        if (this.menuList.size()==0){
            return null;
        }
        for (int i = 0 ;i<this.menuList.size() ; i++){
            if(this.menuList.get(i).getCategory().equals(category)){
                this.itemsByCategory.add(this.menuList.get(i));
            }
        }
        return this.itemsByCategory;
    }

}
