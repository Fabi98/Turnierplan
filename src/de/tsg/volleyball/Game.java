package de.tsg.volleyball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private Team teamA,teamB;
    private Scanner scanner = new Scanner(System.in);


    public Game(Team teamA, Team teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
    }

    public GameResult enter_results(){
        //System.out.println("Please enter ("+teamA.getName()+":"+teamB.getName()+") results like displayed(without brackets):");
        //String result= scanner.next();
        //String[] points = result.split(":");
        //return new GameResult(Integer.parseInt(points[0]),Integer.parseInt(points[1]));
        //System.out.println(getRandomNumberInRange(1,50));
        int unique_1=0,unique_2=0;
        if (Main.count<Main.unique_numbers.length-2){
            unique_1=Main.unique_numbers[Main.count];
            Main.count++;
            unique_2=Main.unique_numbers[Main.count];
            Main.count++;
        }
        return new GameResult(unique_1,unique_2);
    }
    private static int getRandomNumberInRange(int min, int max) {
        //define ArrayList to hold Integer objects
        ArrayList<Integer> numbers = new ArrayList();
        for(int i = min; i < max; i++)
        {
            numbers.add(i+1);
        }
        Collections.shuffle(numbers);
        Random r = new Random();
        return numbers.get(r.nextInt(numbers.size()));
    }
}
