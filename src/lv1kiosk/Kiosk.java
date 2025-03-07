package lv1kiosk;

public class Kiosk {
    private Menu menu = new Menu();
    private String[] hamburgerMenu = {"shackburger","smokeshack","cheeseburger","hamburger"};

    public void showMenu(String category){
        if (category.equals("hamburger")){
            for (String s:hamburgerMenu) {
                String tempa = menu.getItem(s).getName();
                double tempb = menu.getItem(s).getPrice();
                String tempc = menu.getItem(s).getDescription();
                System.out.println("===================");
                System.out.println("tempa+"+s+"="+tempa);
                System.out.println("tempb+"+s+"="+tempb);
                System.out.println("tempc+"+s+"="+tempc);
                System.out.println("===================");
            }
        } else {
            System.out.println("키오스크 시동 실패");
        }
    }
}
