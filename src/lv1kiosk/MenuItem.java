package lv1kiosk;

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

    // method
    // setter
    public void setName(String name) {
        this.name=name;
    }
    public void setPrice(double price) {
        if (price<0l) {
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
