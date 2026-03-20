// 定義一個"偶像電影"類別，繼承寫的"電影"類別
public class IdolMovie extends Movie{
    // 參數：新增私有成員變數"螢光棒"，類別為建立的"螢光棒"
    private LightStick lightStick;

    // 建構元：
        // 傳入除了"電影類別"外的其他參數（包含"螢光棒"），
        // 呼叫父類建構，將"電影類別"改成"紀錄片"，
        // 然後再將傳入的"螢光棒"設給成員變數
    public IdolMovie(String name, String type, int price, String rating, String time, LightStick lightStick){
        super(name, "紀錄片", price, rating, time);
        this.lightStick = lightStick;
    }

    // getter
    public LightStick getLightStick(){
        return lightStick;
    }

    // setter
    public void setLightStick(LightStick lightStick){
        this.lightStick = lightStick;
    }

    // 方法：回傳"螢光棒"的顏色
    public String getLightColor(){
        return lightStick.getColor();
    }
}

