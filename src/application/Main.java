package application;
import entities.Vote;
import services.ReadVotesService;
import java.util.List;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("");
        String path = file.getAbsolutePath() + "/src/votes/in.csv";

        ReadVotesService readVotesService = new ReadVotesService();
        readVotesService.readVotes(path);

        List<Vote> votes = readVotesService.getVotes();
        System.out.println(votes);
    }
}
