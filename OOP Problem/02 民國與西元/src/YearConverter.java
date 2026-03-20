public class YearConverter {
    //參數
    private int n;

    //建構元
    public YearConverter(int n){
        this.n = n;
    }

    //getter：抓目前存的年份
    public int getYear(){
        return n;
    }

    //setter：設定新的年份
    public void setYear(int n){
        this.n = n;
    }

    //方法
    public int convert() {
        if (n < 1911) {
            // 民國年轉西元年
            return n + 1911;
        } 
        else {
            // 西元年轉民國年
            return n - 1911;
        }
    }
}
