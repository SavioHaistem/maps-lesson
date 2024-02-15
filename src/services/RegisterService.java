package services;

import entities.Candidate;
import entities.Vote;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegisterService {
    private final Map<Candidate, Integer> registeredVotes = new HashMap<>();

    public void registerAllVotes() {
    }

    public void registerVotes(List<Vote> voteList) {
        for (Vote vote : voteList) {
            if (registeredVotes.containsKey(vote.getCandidate())) {
                int oldQuaint = registeredVotes.get(vote.getCandidate());
                registeredVotes.replace(vote.getCandidate(),(oldQuaint + vote.getVotes()));
            } else {
                registeredVotes.put(vote.getCandidate(),vote.getVotes());
            }
        }
    }
}
