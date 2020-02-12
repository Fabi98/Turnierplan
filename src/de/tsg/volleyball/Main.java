package de.tsg.volleyball;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static int total_rounds=10;
    static int count=0;
    static int[] unique_numbers =ThreadLocalRandom.current().ints(0, 100).distinct().limit(500).toArray();

    public static void main(String[] args) {



        Team A = new Team("A");
        Team B = new Team("B");
        Team C = new Team("C");
        Team D = new Team("D");
        Team E = new Team("E");
        Team F = new Team("F");
        Team G = new Team("G");
        Team H = new Team("H");
        Team I = new Team("I");

        Field field1 = new Field();
        Field field2 = new Field();
        Field field3 = new Field();

        //Init First Round
        System.out.println("Init Round");
        Ranking[] ranking_fields = new Ranking[3];
        ranking_fields[0] = field1.newRound(A,B,C);
        ranking_fields[1] = field2.newRound(D,E,F);
        ranking_fields[2] = field3.newRound(G,H,I);

        for (int i = 0; i < (total_rounds-1); i++) {
            System.out.println("Round"+(i+2));
            //All Teams ranked first last round
            ranking_fields[0]=field1.newRound(ranking_fields[0].getFirst(),ranking_fields[1].getFirst(),ranking_fields[2].getFirst());
            //All Teams ranked second last round
            ranking_fields[1]=field2.newRound(ranking_fields[0].getSecond(),ranking_fields[1].getSecond(),ranking_fields[2].getSecond());
            //All Teams ranked third last round
            ranking_fields[2]=field3.newRound(ranking_fields[0].getThird(),ranking_fields[1].getThird(),ranking_fields[2].getThird());
        }
        //Play Global Ranking
        ranking_fields = HelperRanking.calc_Global_Ranking(new ArrayList<Team>(Arrays.asList(A,B,C,D,E,F,G,H,I)));
        System.out.println("Ranking Before Finals sorted");

        display_ranking(ranking_fields);
        System.out.println("Final Round");
        //Global Teams Ranked 1,2,3
        ranking_fields[0]=field1.newRound(ranking_fields[0].getFirst(),ranking_fields[1].getFirst(),ranking_fields[2].getFirst());
        //Global Teams Ranked 4,5,6
        ranking_fields[1]=field2.newRound(ranking_fields[0].getSecond(),ranking_fields[1].getSecond(),ranking_fields[2].getSecond());
        //Global Teams Ranked 7,8,9
        ranking_fields[2]=field3.newRound(ranking_fields[0].getThird(),ranking_fields[1].getThird(),ranking_fields[2].getThird());

        ranking_fields = HelperRanking.calc_Global_Ranking(new ArrayList<Team>(Arrays.asList(A,B,C,D,E,F,G,H,I)));
        System.out.println("Ranking After Finals ");
        display_ranking(ranking_fields);



    }
    public static void display_ranking(Ranking[] ranking_fields){
        System.out.println("#1: "+ranking_fields[0].getFirst().getName()+" Wins: "+ranking_fields[0].getFirst().getGlobal_wins()+" Points: "+ranking_fields[0].getFirst().getRound_points());
        System.out.println("#2: "+ranking_fields[0].getSecond().getName()+" Wins: "+ranking_fields[0].getSecond().getGlobal_wins()+" Points: "+ranking_fields[0].getSecond().getRound_points());
        System.out.println("#3: "+ranking_fields[0].getThird().getName()+" Wins: "+ranking_fields[0].getThird().getGlobal_wins()+" Points: "+ranking_fields[0].getThird().getRound_points());
        System.out.println("#4: "+ranking_fields[1].getFirst().getName()+" Wins: "+ranking_fields[1].getFirst().getGlobal_wins()+" Points: "+ranking_fields[1].getFirst().getRound_points());
        System.out.println("#5: "+ranking_fields[1].getSecond().getName()+" Wins: "+ranking_fields[1].getSecond().getGlobal_wins()+" Points: "+ranking_fields[1].getSecond().getRound_points());
        System.out.println("#6: "+ranking_fields[1].getThird().getName()+" Wins: "+ranking_fields[1].getThird().getGlobal_wins()+" Points: "+ranking_fields[1].getThird().getRound_points());
        System.out.println("#7: "+ranking_fields[2].getFirst().getName()+" Wins: "+ranking_fields[2].getFirst().getGlobal_wins()+" Points: "+ranking_fields[2].getFirst().getRound_points());
        System.out.println("#8: "+ranking_fields[2].getSecond().getName()+" Wins: "+ranking_fields[2].getSecond().getGlobal_wins()+" Points: "+ranking_fields[2].getSecond().getRound_points());
        System.out.println("#9: "+ranking_fields[2].getThird().getName()+" Wins: "+ranking_fields[2].getThird().getGlobal_wins()+" Points: "+ranking_fields[2].getThird().getRound_points());
    }

}
