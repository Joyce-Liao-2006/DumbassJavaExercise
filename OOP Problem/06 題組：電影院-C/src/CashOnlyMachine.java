public class CashOnlyMachine implements TicketMachine {
    // 參數
        // Movie[]是陣列
        // Movie movie1 = new Movie("鈴芽之旅", "喜劇片", 250, "普通級", "晚上");
    protected Movie[] movies;

    // 建構元
    public CashOnlyMachine(Movie[] movies) {
        this.movies = movies;
    }

    // 方式
    @Override
    public String[] getMoviesName() {
        String[] names = new String[movies.length]; // 新增一個Array
        for (int i = 0; i < movies.length; i++) {
            names[i] = movies[i].getName();
        }
        return names;
    }

    @Override
    public String buyTicket(String name,int payment) {
        // 初值
        int p = 0;

        for (Movie m:movies) {
            if (m.getName().equals(name)) {  // 比對電影名稱
                p = m.getPrice();            // 找到後取票價
                break;                       // 找到了就停止迴圈
            }
        }

        if (payment == p) {
            return "購買完成!祝您有美好的一天";
        } else if (payment < p) {
            return "購買失敗!金額不足，您應付" + p + "元";
        } else {
            int change = payment - p;
            return "購買完成!找您" + change + "元";
        }
    }
    
    // 多載
        // 無法使用卡片結帳，請回傳錯誤訊息
        // "購買失敗!本機器無法使用信用卡結帳"
    @Override
    public String buyTicket(String name, String cardType) {
        return "購買失敗!本機器無法使用信用卡結帳";
    }
}
