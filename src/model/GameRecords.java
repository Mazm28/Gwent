package model;

import java.util.ArrayList;
import java.util.Date;

public class GameRecords {
    private static ArrayList<GameRecords> gameRecords = new ArrayList<>();
    private int[][] pointsInEachRound = new int[2][3];
    private int[] finalPoints = new int[2];
    private Date date;
    private Player winner;
    private Player opponent;
    @Override
    public String toString(){
        return null;
    }

}
