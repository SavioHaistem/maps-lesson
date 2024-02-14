package services;

import entities.Candidate;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadVotesService {
    private final Map<Candidate, Integer> votes = new HashMap<>();

    public void ReadVotesService() {
    }

    public Map<Candidate, Integer> getVotes() {
        return votes;
    }

    public void readVotes(String machineLogPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(machineLogPath))) {
            String line = reader.readLine();

            while(line != null) {
                String[] splitedLine = line.split(",");
                Candidate candidate = new Candidate(splitedLine[0]);
                Integer vote = Integer.getInteger(splitedLine[1]);

                if (votes.containsKey(candidate)) {
                    int voteAccumulator = votes.get(candidate);
                    votes.replace(candidate,(voteAccumulator + vote));
                } else {
                    votes.put(candidate,vote);
                }

                line = reader.readLine();
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
