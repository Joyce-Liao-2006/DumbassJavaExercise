// 請定義一個"TicketMachine"介面（interface）
// interface不用來實作（implements）
public interface TicketMachine {
    // 方法
        // String[] getMoviesName()的方法，
        // 回傳string陣列
        // String buyTicket(String name,int payment)的方法，
        // 傳入參數
    String[] getMoviesName();
    String buyTicket(String name,int payment);
    String buyTicket(String name,String cardType);
    } 