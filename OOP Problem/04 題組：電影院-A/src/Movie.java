public class Movie {   
    //參數
    private String name;
    private String type;
    private int price;
    private String rating;    
    private String time;

    //建構元：這裡也要判斷句
    public Movie(String name, String type, int price, String rating, String time) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.rating = rating;
        this.time = time;

        if (type.equals("恐怖片")) {
            this.rating = "R18";
        }
        if (time.equals("凌晨")) {
            this.price -= 20;
        }
    }

    //getter：抓目前存的成員變數
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public int getPrice(){
        return price;
    }
    public String getRating(){
        return rating;
    }
    public String getTime(){
        return time;
    }    

    //setter
    public void setName(String name){
        this.name = name;
    }
    public void setType(String type){
        this.type = type;
        //.equals用在判斷
        if (type.equals("恐怖片")) {
            rating = "R18";
        }
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setRating(String rating){
        this.rating = rating;
    }
    public void setTime(String time){
        this.time = time;
        if(time.equals("凌晨")) {
            price -= 20;
        }
    }

    //方法
        //印出所有屬性資料
        //格式：我看了:{電影名稱}，是{電影類別}，分級為{分級}，在{時段}，價格是{票價}
    public void getInfo() {
        //format格式：%s字串格式，%d整數格式
        System.out.println("我看了:"+ name+ "，是"+ type+ "，分級為"+ rating+ "，在"+ time+ "，價格是"+ price);
    }

}
