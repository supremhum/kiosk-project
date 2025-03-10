package lv3kiosk;

public class MenuItem {
    // property
    private String name;
    private double price;
    private String description;

    // structor
    public MenuItem(String name,double price,String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // setter
    public void setName(String name) {
        this.name=name;
    }

    // 핵 발전소 관련 예제를 한번 따라해봄.
    public void setPrice(double price) {
        if (price<0) {
            System.out.println("가격을 음수가 될 수 없습니다");
        } else {
            this.price=price;
        }
    }

    public void setDescription(String description) {
        this.description=description;
    }

    // getter
    public String getName() {
            return this.name;}

    public double getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }
}
