public class Main { 
    public static void main(String[] args) { 
        YearConverter y1 = new YearConverter(113); 
        YearConverter y2 = new YearConverter(2025); 
        System.out.println(y1.convert()); // 輸出 2024 
        System.out.println(y2.convert()); // 輸出 114 
    } 
}  