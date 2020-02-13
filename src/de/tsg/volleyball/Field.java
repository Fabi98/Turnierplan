package de.tsg.volleyball;


import java.util.*;

public class Field {

    public Ranking newRound(Team A, Team B, Team C) {
        //Init Games [Game against all]

        Game gameAB = new Game(A, B);
        Game gameAC = new Game(A, C);
        Game gameBC = new Game(B, C);

        //Play Game 1 ----------------------------------------------------
        GameResult resultAB = gameAB.enter_results();

        //Set points AB
        A.setRound_points(resultAB.getPointsA());
        B.setRound_points(resultAB.getPointsB());
        //Set wins AB
        A.setRound_wins(resultAB.getWinsA());
        B.setRound_wins(resultAB.getWinsB());

        //Play Game 2 ----------------------------------------------------
        GameResult resultAC = gameAC.enter_results();

        //Set points AC
        A.setRound_points(resultAC.getPointsA());
        C.setRound_points(resultAC.getPointsB());
        //Set wins AC
        A.setRound_wins(resultAC.getWinsA());
        C.setRound_wins(resultAC.getWinsB());

        //Play Game 3 ----------------------------------------------------
        GameResult resultBC = gameBC.enter_results();

        //Set points BC
        B.setRound_points(resultBC.getPointsA());
        C.setRound_points(resultBC.getPointsB());
        //Set wins BC
        B.setRound_wins(resultBC.getWinsA());
        C.setRound_wins(resultBC.getWinsB());

        return HelperRanking.calc_Ranking(new ArrayList<Team>(Arrays.asList(A, B, C)));
    }
}
