package services;

import entities.Candidate;
import entities.Vote;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadVotesService {
    private final List<Vote> votes = new ArrayList<>();

    public void ReadVotesService() {
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void readVotes(String machineLogPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(machineLogPath))) {
            System.out.println(machineLogPath);
            String line = reader.readLine();
            while(line != null) {
                String[] splitedLine = line.split(",");
                Candidate candidate = new Candidate(splitedLine[0]);
                Integer quantity = Integer.parseInt(splitedLine[1]);
                Vote vote = new Vote(candidate,quantity);
                votes.add(vote);
                line = reader.readLine();
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
