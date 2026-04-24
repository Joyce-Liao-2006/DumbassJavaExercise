public class Workshop extends Activity implements Registrable, Certifiable {
    private int materialFee;

    public Workshop(String name, String date, int maxParticipants, int materialFee) {
        super(name, date, maxParticipants);
        this.materialFee = materialFee;
    }

    @Override
    public void showInfo() {
        System.out.println("Activity: " + name);
        System.out.println("Date: " + date);
        System.out.println("Type: Workshop");
        System.out.println("Material Fee: " + materialFee);
        System.out.println("Max Participants: " + maxParticipants);
        System.out.println("Current Participants: " + participantCount);
        System.out.println("Score: " + calculateScore());
        System.out.println("Participant List:");
        for (int i = 0; i < participantCount; i++) {
            System.out.println("  - " + participants[i].getStudentName() + 
                (participants[i].isAttended() ? " (Attended)" : ""));
        }
    }

    @Override
    public double calculateScore() {
        return 100 - materialFee;
    }

    @Override
    public boolean register(String studentName) {
        return addParticipant(studentName);
    }

    @Override
    public boolean canGetCertificate(String studentName) {
        Participant p = findParticipant(studentName);
        return p != null && p.isAttended();
    }

    public void markAttendance(String studentName) {
        Participant p = findParticipant(studentName);
        if (p != null) {
            p.markAttended();
        }
    }
}