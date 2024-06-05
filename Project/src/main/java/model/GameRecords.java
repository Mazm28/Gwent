package model;

import model.card.RegularCardInformation;

import java.util.ArrayList;
import java.util.Date;

public class GameRecords {
    private int[][] pointsInEachRound = new int[2][3];
    private int[] finalPoints = new int[2];
    private Date date;
    private Player winner;
    private Player opponent;

    public GameRecords(int[][] pointsInEachRound, int[] finalPoints, Date date, Player winner, Player opponent) {
        this.pointsInEachRound = pointsInEachRound;
        this.finalPoints = finalPoints;
        this.date = date;
        this.winner = winner;
        this.opponent = opponent;
    }

    @Override
    public String toString(){
        return null;
    }

}
