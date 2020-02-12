package de.tsg.volleyball;

public class Team {
    private String name;
    private int global_wins,global_points, round_wins, round_points;

    public Team(String name) {
        this.name = name;
    }

    public int getGlobal_wins() {
        return global_wins;
    }

    public int getGlobal_points() {
        return global_points;
    }

    public int getRound_wins() {
        return round_wins;
    }

    public void setRound_wins(int round_wins) {
        this.round_wins = round_wins;

        global_wins += round_wins;
    }

    public int getRound_points() {
        return round_points;
    }

    public void setRound_points(int round_points) {
        this.round_points = round_points;

        global_points += round_points;
    }

    public String getName() {
        return name;
    }
}
