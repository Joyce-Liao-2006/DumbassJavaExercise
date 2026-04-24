public class Bit { 
    //參數
    private int n;

    //建構元  初始化參數
    public Bit(int n){
        this.n = n;
    }

    //方法
    public int flip(){
        if (n == 0){
            return 1;
        }
        else{
            return 0;
        }
    }
}