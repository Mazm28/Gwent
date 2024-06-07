package model;

import java.io.Serializable;
import java.util.Date;

public class GameRecord implements Serializable {
    private int[][] pointsInEachRound = new int[2][3];
    private int[] finalPoints = new int[2];
    private Date date;
    private Player winner;
    private Player opponent;

    public GameRecord(int[][] pointsInEachRound, int[] finalPoints, Date date, Player winner, Player opponent) {
        this.pointsInEachRound = pointsInEachRound;
        this.finalPoints = finalPoints;
        this.date = date;
        this.winner = winner;
        this.opponent = opponent;
    }

    public int[][] getPointsInEachRound() {
        return pointsInEachRound;
    }

    public int[] getFinalPoints() {
        return finalPoints;
    }

    public Date getDate() {
        return date;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getOpponent() {
        return opponent;
    }

    @Override
    public String toString() {
        return "Enemy: " +
                opponent.getUsername() +
                "\n" +
                date +
                "\nYour point in each round: " + pointsInEachRound[0][0] + ", " +
                pointsInEachRound[0][1] + ", " +
                pointsInEachRound[0][2] +
                "\nYour enemy point in each round: " + pointsInEachRound[1][0] + ", " +
                pointsInEachRound[1][1] + ", " +
                pointsInEachRound[1][2] +
                "\nYour final point: " + finalPoints[0] +
                "\nYour enemy final point: " + finalPoints[1] +
                "\nWinner: " + winner.getUsername() + "\n";
    }
}
