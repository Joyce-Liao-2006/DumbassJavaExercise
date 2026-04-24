public class CashMachine extends CashOnlyMachine implements TicketMachine {
    // 建構元
    public CashMachine(Movie[] movies) {
        super(movies);
    }

    // 方式
    @Override
    public String buyTicket(String name,int cardType) {
        // 初值
        int price = 0;

        for (Movie m:super.movies) {
            if (m.getName().equals(name)) {  // 比對電影名稱
                price = m.getPrice();            // 找到後取票價
                break;                       // 找到了就停止迴圈
            }
        }
        
        return "購買成功!你本次消費金額為" + price + "，請領回您的信用卡";
    }
}
