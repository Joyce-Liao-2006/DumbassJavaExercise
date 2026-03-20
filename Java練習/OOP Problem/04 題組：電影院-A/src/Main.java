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
    }
}