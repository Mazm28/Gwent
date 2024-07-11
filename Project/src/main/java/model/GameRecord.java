package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

public record GameRecord(int[][] pointsInEachRound, int[] finalPoints, String date, @JsonIgnoreProperties Player winner,
                         @JsonIgnoreProperties Player opponent) implements Serializable {

    @Override
    public Player winner() {
        return winner;
    }

    @Override
    public Player opponent() {
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
