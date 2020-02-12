package de.tsg.volleyball;

import java.util.List;

public class Ranking {
    private Team first,second,third;

    public Ranking(List<Team> teams) {
            //Assume List is sorted by wins (first important) and points (second important)
            this.first = teams.get(0);
            this.second = teams.get(1);
            this.third = teams.get(2);
    }

    public Team getFirst() {
        return first;
    }

    public void setFirst(Team first) {
        this.first = first;
    }

    public Team getSecond() {
        return second;
    }

    public void setSecond(Team second) {
        this.second = second;
    }

    public Team getThird() {
        return third;
    }

    public void setThird(Team third) {
        this.third = third;
    }
}
