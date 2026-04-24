public class Lecture extends Activity implements Registrable, Certifiable {
    private int hours;

    public Lecture(String name, String date, int maxParticipants, int hours) {
        super(name, date, maxParticipants);
        this.hours = hours;
    }

    @Override
    public void showInfo() {
        System.out.println("Activity: " + name);
        System.out.println("Date: " + date);
        System.out.println("Type: Lecture");
        System.out.println("Hours: " + hours);
        System.out.println("Max Participants: " + maxParticipants);
        System.out.println("Current Participants: " + participantCount);
        System.out.println("Score: " + calculateScore());
        System.out.println("Participant List:");
        for (int i = 0; i < participantCount; i++) {
            System.out.println("  - " + participants[i].getStudentName());
        }
    }

    @Override
    public double calculateScore() {
        return hours * 10;
    }

    @Override
    public boolean register(String studentName) {
        return addParticipant(studentName);
    }

    @Override
    public boolean canGetCertificate(String studentName) {
        return isRegistered(studentName);
    }
}