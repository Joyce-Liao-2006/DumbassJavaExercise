import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> scores1 = Arrays.asList(95, 98, 92, 96, 94);
        Score s1 = new Score("Alice", scores1, 18);
        System.out.println(s1.getAge());
        System.out.println(s1.average());
        System.out.println(s1.rank());

        List<Integer> scores2 = Arrays.asList(85, 88, 82, 90, 84, 86);
        Score s2 = new Score("Bob", scores2, 20);
        System.out.println(s2.getAge());
        System.out.println(s2.average());
        System.out.println(s2.rank());

        List<Integer> scores3 = Arrays.asList(72, 68, 75, 74);
        Score s3 = new Score("Charlie", scores3, 19);
        System.out.println(s3.getAge());
        System.out.println(s3.average());
        System.out.println(s3.rank());

        List<Integer> scores4 = Arrays.asList(65, 62, 68);
        Score s4 = new Score("David", scores4, 21);
        System.out.println(s4.getAge());
        System.out.println(s4.average());
        System.out.println(s4.rank());
    }
}

// Anser:
// 18
// 95.0
// A+
// 20
// 85.8
// A
// 19
// 73.7
// B
// 21
// 66.5
// C