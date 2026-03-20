import java.util.*;

public class Score {
    // 參數
    private String name;
    private List<Integer> scores;
    private int age;
    
    // 建構元：接收 name、scores、age 三个参数
    public Score(String name, List<Integer> scores, int age) {
        this.name = name;
        this.scores = scores;
        this.age = age;
    }

    // getter
    public String getName(){
        return name;
    }
    public List<Integer> getScores(){
        return scores;
    }
    public int getAge(){
        return age;
    }
    
    // setter
    public void setName(String name){
        this.name = name;
    }
    public void setScores(List<Integer> scores){
        this.scores = scores;
    }
    public void setAge(int age){
        this.age = age;
    }

    // 方法
        // 有一個「計算平均」的方法，average()，計算方式如下：
        // 1. 若「分數個數」≥5，排序後，去除「1個最低分」和「1個最高分」，再算剩餘者平均
        // 2. 否則，去除「1個最低分」後，再算剩餘者平均
        // 3. 計算後平均分數，四捨五入至小數一位
    public double average(){
        // 先複製一份，避免改動原本的資料
        List<Integer> sorted = new ArrayList<>(scores);

        // 初值
        double sum = 0.0;
        int count = 0;

        // 排序：從小到大
        Collections.sort(sorted);

        if (sorted.size() >= 5){
            // 去掉第0位（最低分）和最后1位（最高分），只算中间的
            for (int i = 1; i < sorted.size() -1; i++) {
                sum += sorted.get(i);
                // 統計有效成績
                count ++;
            } 
        } else{
            for (int i = 1; i < sorted.size(); i++) {
                sum += sorted.get(i);
                // 統計有效成績
                count ++;
            }
        }
    
        // 計算平均
        double avg = Math.round((sum / count)*10.0)/10.0; 
        return avg;
    }

        // 有一個「判斷等級」的方法，rank()，判斷方式如下：
        // 1. 若「平均分數」> 90，等級為「A+」
        // 2. 否則，若「平均分數」> 80，等級為「A」
        // 3. 否則，若「平均分數」> 70，等級為「B」
        // 4. 否則，若「平均分數」> 60，等級為「C」
        // 5. 否則，等級為「D」
    public String rank(){
        // 先調用上面的average() 方法，拿平均分
        double avg = average();

        if(avg > 90){
            return "A+";
        } else if(avg > 80){
            return "A";
        } else if(avg > 70){
            return "B";
        } else if(avg > 60){
            return "C";
        } else{
            return "D";
        }
    }
}
