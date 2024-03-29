package entities;

public class Vote {
    private Candidate candidate;
    private Integer votes;

    public Vote(Candidate candidate, Integer votes) {
        this.candidate = candidate;
        this.votes = votes;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public Integer getVotes() {
        return votes;
    }

    @Override
    public String toString() {
        return "vote { candidate: " + candidate + ", votes: " + votes + " }";
    }
}
