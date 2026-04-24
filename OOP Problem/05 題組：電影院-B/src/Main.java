public class Main {
    public static void main(String[] args) {
        LightStick lightStick = new LightStick();
        lightStick.setColor("粉色");
        lightStick.setShape("心型");
        lightStick.setStatus(false);

        System.out.println(lightStick.getColor());
        System.out.println(lightStick.getShape());
        System.out.println(lightStick.isStatus());

        lightStick.open();
        System.out.println(lightStick.isStatus());

        Movie movie = new Movie("唐伯虎點秋香", "喜劇片", 250, "普通級", "晚上");
        movie.getInfo();

        movie.setName("少林足球");
        movie.setPrice(100);
        movie.getInfo();

        movie.setType("恐怖片");
        movie.setTime("凌晨");
        movie.getInfo();

        LoveMovie loveMovie = new LoveMovie("鐵達尼號", 250, "普遍級", "晚上");
        System.out.println(loveMovie);
        loveMovie.getInfo();

        IdolMovie idolMovie = new IdolMovie("black pink紀錄片", 300, "普遍級", "下午", lightStick);
        idolMovie.getInfo();
        System.out.println(idolMovie.getLightColor());

    }
}

// Anser:
// 粉色
// 心型
// false
// true
// 我看了:唐伯虎點秋香，是喜劇片，分級為普通級，在晚上，價格是250
// 我看了:少林足球，是喜劇片，分級為普通級，在晚上，價格是100
// 我看了:少林足球，是恐怖片，分級為R18，在凌晨，價格是80
// 這是一部愛情片
// 我看了:鐵達尼號，是愛情片，分級為普遍級，在晚上，價格是250
// 我看了:black pink紀錄片，是紀錄片，分級為普遍級，在下午，價格是300
// 粉色