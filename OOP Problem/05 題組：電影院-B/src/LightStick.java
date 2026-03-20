public class LightStick {
    // 這題的Main.py中
    // LightStick lightStick = new LightStick()
    // 沒有下變數（括號裡沒下變數）
    // 所以這題可以跳過「建構元」            
    
    //參數
    private String color;
    private String shape;
    private boolean status;

    //getter：抓目前存的成員變數
    public String getColor(){
        return color;
    }
    public String getShape(){
        return shape;
    }
    public boolean isStatus(){
        return status;
    } 
 
    //setter 
    public void setColor(String color){
        this.color = color;
    }
    public void setShape(String shape){
        this.shape = shape;
    }
    public void setStatus(boolean status){
        this.status = status;
    }

    //方法
        //建立兩個公開方法，
        //分別為開 (open) 跟關 (close)，控制 "狀態" 的開關
        //（方法裡面請使用 setter 操作）
    public void open() {
        setStatus(true) ;
    }
    public void close() {
        setStatus(false) ;
    }
    //因為是直接輸出不用回傳，直接用void。
}
