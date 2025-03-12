package lv5kiosk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Payment {
    // 결제 관련된 기능을 넣어봅니다.
    private int totalAmount;
    private int totalAmountPaid = 0;
    private String payType;
    private List<String> cardList = new ArrayList<>(Arrays.asList(
            "신용카드","체크카드","교통카드","카드뮴"
    ));

    public Payment(int totlaAmount,String payType) {
        this.payType = payType;
        this.totalAmount = totlaAmount;
    }

    // 결제 완료 여부는 boolean으로 반환
    public boolean process (int amount) {
        // 결제에 필요한 금액이 있다.
        // 여기선 금액을 받는다.
        this.totalAmountPaid += amount;
        if (this.payType.equals("현금")) {
            if (this.totalAmountPaid>=this.totalAmount) {
                return true;
            } else {
                return false;
            }
        } else if (this.payType.equals("카드")) {
            // 카드부터 하면
            return true;
        } else {
            System.out.println("구현되지 않은 결제방식입니다.");
            return false;
        }
    }

    // getter
    public int getTotalAmount(){
        return this.totalAmount;
    }
    public int getTotalAmountPaid(){
        return this.totalAmountPaid;
    }
    public List<String> getCardList () {
        return this.cardList;
    }

    // setter
    public void resetTotalAmountPaid() {
        this.totalAmountPaid=0;
    }
}
