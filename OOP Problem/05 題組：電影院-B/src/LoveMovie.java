// 定義一個"愛情電影"類別，繼承寫的"電影"類別
public class LoveMovie extends Movie {
    // 建構元：
        // 呼叫父類建構元，
        // 傳入除了"電影類別"外的其他參數，
        // 將原本的"電影類別"改成直接改成寫入"愛情片"字串
    public LoveMovie(String name, String type, int price, String rating, String time){
        super(name, "愛情片", price, rating, time);
    }

    // 覆寫(@Override) toString()，
    // 回傳內容為：這是一部{"電影類別"}（{} => 代表變數）
    @Override
    public String toString() {
        return "這是一部" + getType();    //  getType()
        }
}
