package entities;

public class Candidate implements Comparable<Candidate> {
    private String name;

    public Candidate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Candidate o) {
        return 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
