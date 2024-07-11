package model;

import controller.ActionController;
import javafx.scene.Node;
import model.card.Card;
import model.card.RegularCardInformation;
import model.card.SpecialCard;
import model.card.SpecialCardInformation;

import java.util.ArrayList;

public class Game {
    private Player currentPlayer;
    private Player opponent;
    private Player player1;
    private Player player2;
    private int turn = 1;
    private int roundNumber = 1;
    private ArrayList<Card> SpecialCards;
    private Round[] rounds = new Round[3];
    private Round currentRound;
    private final Row[] rows = new Row[6];
    private Card action;
    private final ArrayList<Card> weathersCards = new ArrayList<>();
    private Node actionNode;

    public Node getActionNode() {
        return actionNode;
    }

    public void setActionNode(Node actionNode) {
        this.actionNode = actionNode;
    }

    public ArrayList<Card> getWeathersCards() {
        return weathersCards;
    }

    public void setRound(Round round){
        rounds[roundNumber - 1] = round;
    }

    public Round[] getRounds() {
        return rounds;
    }

    public Card getAction() {
        return action;
    }

    public void setAction(Card action) {
        this.action = action;
    }
    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public Game(Player player_one, Player player_two) {
        this.currentPlayer = player_one;
        this.opponent = player_two;
        this.player1 = player_one;
        this.player2 = player_two;
        for(int i=0;i<3;i++){
            rows[i] = player_one.getRows()[i];
        }
        for(int i=3;i<6;i++){
            rows[i] = player_two.getRows()[i-3];
        }
        ActionController.setGame(this);
    }

    public void setRows(Row[] rows, Row[] rows1){

    }


    public int getRoundNumber() {
        return roundNumber;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getOpponent() {
        return opponent;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public void changeTurn() {
        Player temp = currentPlayer;
        this.currentPlayer = this.opponent;
        this.opponent = temp;
        turn++;
        for(Row row: currentPlayer.getRows()){
            for(Card card: row.getCards()){
                if(card != null && card.getName().equals(SpecialCardInformation.Cow.getName())){
                    ActionController.cowTransform((SpecialCard)card);
                }
            }
        }
    }

    public Row[] getRows() {
        return rows;
    }

    public Round getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(Round currentRound) {
        this.currentRound = currentRound;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void addToWeathersCards(Card card){
        weathersCards.add(card);
    }

    public void removeFromWeathersCards(Card card){
        weathersCards.remove(card);
    }

    public void setSpecialCards(ArrayList<Card> specialCards) {
        SpecialCards = specialCards;
    }

    public ArrayList<Card> getSpecialCards() {
        return SpecialCards;
    }
}
