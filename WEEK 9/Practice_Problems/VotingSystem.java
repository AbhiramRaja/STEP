public class VotingSystem {
    public void processVote(String voterId, String candidate) {
        class VoteValidator {
            boolean validate(String id) {
                // simple check: non-null and length > 3
                return id != null && id.length() > 3;
            }
        }

        VoteValidator validator = new VoteValidator();
        if (validator.validate(voterId)) {
            System.out.println("Vote accepted for " + candidate + " from " + voterId);
        } else {
            System.out.println("Invalid voter ID: " + voterId);
        }
    }

    public static void main(String[] args) {
        VotingSystem vs = new VotingSystem();
        vs.processVote("V123", "Alice");
        vs.processVote("X", "Bob");
    }
}