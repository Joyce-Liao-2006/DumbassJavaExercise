import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Activity[] activities = new Activity[3];

        activities[0] = new Lecture("AI_Lecture", "2026-05-01", 2, 3);
        activities[1] = new Competition("Hackathon", "2026-05-10", 3, 80, 85, 90);
        activities[2] = new Workshop("UI_Workshop", "2026-05-15", 2, 50);

        System.out.println("=== Register Result ===");
        testRegister((Registrable) activities[0], "AI_Lecture", "Alice");
        testRegister((Registrable) activities[0], "AI_Lecture", "Bob");
        testRegister((Registrable) activities[0], "AI_Lecture", "Bob");
        testRegister((Registrable) activities[0], "AI_Lecture", "Carol");

        testRegister((Registrable) activities[1], "Hackathon", "Tom");
        testRegister((Registrable) activities[1], "Hackathon", "Jane");

        testRegister((Registrable) activities[2], "UI_Workshop", "Mary");
        testRegister((Registrable) activities[2], "UI_Workshop", "John");

        ((Workshop) activities[2]).markAttendance("Mary");

        System.out.println();

        System.out.println("=== Activity Info ===");
        for (int i = 0; i < activities.length; i++) {
            activities[i].showInfo();
            System.out.println();
        }

        System.out.println("=== Award / Certificate Check ===");
        for (int i = 0; i < activities.length; i++) {
            System.out.println("Activity: " + activities[i].getName());

            if (activities[i] instanceof Awardable) {
                Awardable a = (Awardable) activities[i];
                System.out.println("Award Level: " + a.getAwardLevel());
            }

            if (activities[i] instanceof Certifiable) {
                Certifiable c = (Certifiable) activities[i];
                System.out.println("Alice certificate: " + c.canGetCertificate("Alice"));
                System.out.println("Mary certificate: " + c.canGetCertificate("Mary"));
                System.out.println("John certificate: " + c.canGetCertificate("John"));
            }

            System.out.println();
        }

        System.out.println("=== Sorted Activities ===");
        Arrays.sort(activities, (a, b) -> Double.compare(b.calculateScore(), a.calculateScore()));

        for (int i = 0; i < activities.length; i++) {
            System.out.println(activities[i].getName() + " " + activities[i].calculateScore());
        }
    }

    public static void testRegister(Registrable r, String activityName, String studentName) {
        boolean result = r.register(studentName);

        if (result) {
            System.out.println("Register: " + studentName + " -> " + activityName + " SUCCESS");
        } else {
            System.out.println("Register: " + studentName + " -> " + activityName + " FAIL");
        }
    }
}
