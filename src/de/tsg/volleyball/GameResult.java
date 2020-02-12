package de.tsg.volleyball;

import java.util.Random;

public class GameResult {
    private int pointsA,pointsB;
    private int winsA, winsB;

    public GameResult(int pointsA, int pointsB) {
        this.pointsA = pointsA;
        this.pointsB = pointsB;

        //Determine Winner
        if (pointsA > pointsB){
            System.out.println("Team A wins!");
            winsA++;

        }else if (pointsB > pointsA){
            System.out.println("Team B wins!");
            winsB++;
        }
        else {
            System.out.println("Tie! Both Teams Win");
            Random r = new Random();
            if (r.nextInt()%2==0){
                winsA++;
            }else {
                winsB++;
            }
        }
    }

    public int getPointsA() {
        return pointsA;
    }

    public int getPointsB() {
        return pointsB;
    }

    public int getWinsA() {
        return winsA;
    }

    public int getWinsB() {
        return winsB;
    }
}
