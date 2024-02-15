package application;
import entities.Vote;
import services.ReadVotesService;
import services.RegisterService;

import java.io.IOException;
import java.util.List;
import java.io.File;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("");
        String path = file.getAbsolutePath() + "/src/votes/";

        RegisterService registerService = new RegisterService();
        ReadVotesService readVotesService = new ReadVotesService();
        readVotesService.readVotes(path + "in.csv");

        List<Vote> votes = readVotesService.getVotes();
        registerService.votesAccumulator(votes);
        registerService.registerVotes(path + "out.csv");
        System.out.println(votes);
    }
}
