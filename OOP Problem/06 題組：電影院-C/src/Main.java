import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Movie movie1 = new Movie("鈴芽之旅", "喜劇片", 250, "普通級", "晚上");
        Movie movie2 = new Movie("霍爾的移動城堡", "喜劇片", 250, "普通級", "晚上");
        Movie movie3 = new Movie("灌籃高手 THE FIRST SLAM DUNK", "喜劇片", 250, "普通級", "晚上");

        Movie[] movies = {movie1, movie2, movie3};
        TicketMachine oldMachine = new CashOnlyMachine(movies);
        System.out.println(Arrays.toString(oldMachine.getMoviesName()));
        System.out.println(oldMachine.buyTicket("鈴芽之旅",100));
        System.out.println(oldMachine.buyTicket("霍爾的移動城堡",250));
        System.out.println(oldMachine.buyTicket("灌籃高手 THE FIRST SLAM DUNK",300));
        System.out.println(oldMachine.buyTicket("鈴芽之旅","信用卡"));

        TicketMachine newMachine = new CashMachine(movies);
        System.out.println(Arrays.toString(newMachine.getMoviesName()));
        System.out.println(newMachine.buyTicket("鈴芽之旅",100));
        System.out.println(newMachine.buyTicket("霍爾的移動城堡",250));
        System.out.println(newMachine.buyTicket("灌籃高手 THE FIRST SLAM DUNK",300));
        System.out.println(newMachine.buyTicket("灌籃高手 THE FIRST SLAM DUNK","信用卡"));

    }
}

// Anser:
// [鈴芽之旅, 霍爾的移動城堡, 灌籃高手 THE FIRST SLAM DUNK]
// 購買失敗!金額不足，您應付 250 元
// 購買完成!祝您有美好的一天
// 購買完成!找您 50 元
// 購買失敗!本機器無法使用信用卡結帳
// [鈴芽之旅, 霍爾的移動城堡, 灌籃高手 THE FIRST SLAM DUNK]
// 購買失敗!金額不足，您應付 250 元
// 購買完成!祝您有美好的一天
// 購買完成!找您 50 元
// 購買成功!你本次消費金額為 250，請領回您的信用卡
