public abstract class Activity {
    protected String name;
    protected String date;
    protected int maxParticipants;
    protected Participant[] participants;
    protected int participantCount;

    public Activity(String name, String date, int maxParticipants) {
        this.name = name;
        this.date = date;
        this.maxParticipants = maxParticipants;
        this.participants = new Participant[maxParticipants];
        this.participantCount = 0;
    }

    public String getName() {
        return name;
    }

    public abstract void showInfo();

    public abstract double calculateScore();

    protected boolean isRegistered(String studentName) {
        for (int i = 0; i < participantCount; i++) {
            if (participants[i].getStudentName().equals(studentName)) {
                return true;
            }
        }
        return false;
    }

    protected boolean addParticipant(String studentName) {
        if (participantCount >= maxParticipants) {
            return false;
        }
        if (isRegistered(studentName)) {
            return false;
        }
        participants[participantCount] = new Participant(studentName);
        participantCount++;
        return true;
    }

    protected Participant findParticipant(String studentName) {
        for (int i = 0; i < participantCount; i++) {
            if (participants[i].getStudentName().equals(studentName)) {
                return participants[i];
            }
        }
        return null;
    }

    public class Participant {
        private String studentName;
        private boolean attended;

        public Participant(String studentName) {
            this.studentName = studentName;
            this.attended = false;
        }

        public String getStudentName() {
            return studentName;
        }

        public boolean isAttended() {
            return attended;
        }

        public void markAttended() {
            this.attended = true;
        }
    }
}