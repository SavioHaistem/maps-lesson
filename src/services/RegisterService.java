package services;

import entities.Candidate;
import entities.Vote;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RegisterService {
    private final Map<Candidate, Integer> accumulatedVotes = new LinkedHashMap<>();

    public void registerAllVotes() {
    }

    public void votesAccumulator(List<Vote> voteList) {
        for (Vote vote : voteList) {
            if (accumulatedVotes.containsKey(vote.getCandidate())) {
                int oldQuaint = accumulatedVotes.get(vote.getCandidate());
                accumulatedVotes.replace(vote.getCandidate(),(oldQuaint + vote.getVotes()));
            } else {
                accumulatedVotes.put(vote.getCandidate(),vote.getVotes());
            }
        }

    }

    public void registerVotes(String path) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (Candidate candidateKey : accumulatedVotes.keySet()) {
                writer.write(candidateKey.getName() + " ,");
                writer.write(accumulatedVotes.get(candidateKey).toString());
                writer.newLine();
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
