package lv3kiosk;

public class MenuItem {
    // property
    private String name;
    private double price;
    private String description;
    private String cuisineType;

    // structor
    public MenuItem(String name,double price,String description,String cuisineType) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.cuisineType = cuisineType;
    }

    // setter
    public void setName(String name) {
        this.name=name;
    }
    public void setDescription(String description) {
        this.description=description;
    }
    public void setCuisineType(String cuisineType) {this.cuisineType = cuisineType;}
    // 핵 발전소 관련 예제를 한번 따라해봄.
    public void setPrice(double price) {
        if (price<0) {
            System.out.println("가격을 음수가 될 수 없습니다");
        } else {
            this.price=price;
        }
    }

    // getter
    public String getName() {return this.name;}
    public double getPrice() {
        return this.price;
    }
    public String getDescription() {
        return this.description;
    }
    public String getCuisineType() {return this.cuisineType;}
}
