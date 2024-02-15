package entities;

import java.util.Objects;

public class Vote {
    private final Candidate candidate;
    private final Integer votes;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return Objects.equals(candidate, vote.candidate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidate);
    }
}
