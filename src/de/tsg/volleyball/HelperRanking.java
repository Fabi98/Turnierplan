package de.tsg.volleyball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HelperRanking {
    public static Ranking calc_Ranking(ArrayList<Team> teams){
        sortTeams(teams);

        return new Ranking(teams);
    }

    public static Ranking[] calc_Global_Ranking(ArrayList<Team> teams){
        sortTeamsGlobal(teams);

        //Subdivide List for each Field
        Ranking field1 = new Ranking(teams.subList(0,3));
        Ranking field2 = new Ranking(teams.subList(3,6));
        Ranking field3 = new Ranking(teams.subList(6,9));

        return new Ranking[]{field1,field2,field3};
    }

    //Sort Teams (ORDER BY wins,points)
    private static void sortTeams(ArrayList<Team> teams) {
        //first name comparator
        Comparator<Team> compareByRoundWins = Comparator.comparing( Team::getRound_wins );

        //last name comparator
        Comparator<Team> compareByRoundPoints = Comparator.comparing( Team::getRound_points );

        //Compare by first name and then last name (multiple fields)
        Comparator<Team> compareByWinsandPoints = compareByRoundWins.thenComparing(compareByRoundPoints);

        //Use Comparator
        Collections.sort(teams, compareByWinsandPoints);
    }
    private static void sortTeamsGlobal(ArrayList<Team> teams) {
        //first name comparator
        Comparator<Team> compareByglobalWins = Comparator.comparing( Team::getGlobal_wins );

        //last name comparator
        Comparator<Team> compareByGlobalPoints = Comparator.comparing( Team::getGlobal_points );

        //Compare by first name and then last name (multiple fields)
        Comparator<Team> compareByWinsandPoints = compareByglobalWins.thenComparing(compareByGlobalPoints);

        //Use Comparator
        Collections.sort(teams, compareByWinsandPoints.reversed());
    }
}
