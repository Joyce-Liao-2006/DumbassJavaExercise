public class Competition extends Activity implements Registrable, Awardable {
    private double score1;
    private double score2;
    private double score3;

    public Competition(String name, String date, int maxParticipants, double score1, double score2, double score3) {
        super(name, date, maxParticipants);
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    @Override
    public void showInfo() {
        System.out.println("Activity: " + name);
        System.out.println("Date: " + date);
        System.out.println("Type: Competition");
        System.out.println("Judge Scores: " + score1 + ", " + score2 + ", " + score3);
        System.out.println("Max Participants: " + maxParticipants);
        System.out.println("Current Participants: " + participantCount);
        System.out.println("Average Score: " + calculateScore());
        System.out.println("Award Level: " + getAwardLevel());
        System.out.println("Participant List:");
        for (int i = 0; i < participantCount; i++) {
            System.out.println("  - " + participants[i].getStudentName());
        }
    }

    @Override
    public double calculateScore() {
        return (score1 + score2 + score3) / 3.0;
    }

    @Override
    public String getAwardLevel() {
        double avg = calculateScore();
        if (avg >= 90) {
            return "Gold";
        } else if (avg >= 80) {
            return "Silver";
        } else if (avg >= 70) {
            return "Bronze";
        } else {
            return "None";
        }
    }

    @Override
    public boolean register(String studentName) {
        return addParticipant(studentName);
    }
}