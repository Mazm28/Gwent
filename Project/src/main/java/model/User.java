package model;

import Enums.Faction;
import Enums.SelectQuestionTexts;
import model.card.Card;
import model.card.LeaderCard;
import model.card.RegularCard;
import model.card.SpecialCard;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private static User loggedInUser;
    private ArrayList<GameRecord> gameRecords = new ArrayList<>();
    private String username;
    private String password;
    private ArrayList<Deck> decks = new ArrayList<>();
    private String email;
    private String nickname;
    private SelectQuestionTexts selectQuestionTexts;
    private String answer;
    private final int id;
    private static User tempUser;
    private boolean remembered = false;
    private ArrayList<Card> allCards = new ArrayList<>();
    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public User(User user) {
        this.username = user.username;
        this.password = user.password;
        this.email = user.email;
        this.nickname = user.nickname;
        this.id = user.id;
    }

    public boolean isRemembered() {
        return remembered;
    }

    public void setRemembered(boolean remembered) {
        this.remembered = remembered;
    }

    public int getHighestScore() {
        int point = 0;
        for (GameRecord gameRecord : gameRecords) {
            if (gameRecord.getFinalPoints()[0] > point) point = gameRecord.getFinalPoints()[0];
        }
        return point;
    }

    public static User getTempUser() {
        return tempUser;
    }

    public static void setTempUser(User tempUser) {
        User.tempUser = tempUser;
    }

    public int getId() {
        return id;
    }

    public User(String username, String password, String email, String nickname) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.id = App.getUsers().size();
    }
    public void makeAllCards(){
        allCards.addAll(RegularCard.makeCards());
        allCards.addAll(SpecialCard.makeCards());
        allCards.addAll(LeaderCard.makeCards());
    }
    public void removeCard(Card card){
        allCards.remove(allCards.indexOf(card));
    }

    public void addToAllCards(Card card){
        allCards.add(card);
    }


    public ArrayList<Card> getSpecialCards(){
        ArrayList<Card> specialCards = new ArrayList<>();
        for(Card card: allCards){
            if(card.getCardType().equals("Special")){
                specialCards.add(card);
            }
        }
        return specialCards;
    }

    public ArrayList<Card> getAllCards() {
        return allCards;
    }

    public static User getUserByUsername(String username) {
        for (User user : App.getUsers()) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        User.loggedInUser = loggedInUser;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void addToGameRecords(GameRecord gameRecord) {
        this.gameRecords.add(gameRecord);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setSelectQuestionTexts(SelectQuestionTexts selectQuestionTexts) {
        this.selectQuestionTexts = selectQuestionTexts;
    }

    public SelectQuestionTexts getSelectQuestionTexts() {
        return selectQuestionTexts;
    }

    public int getRank() {
        return 0;
    }

    public ArrayList<GameRecord> getGameRecords() {
        return gameRecords;
    }

    public void addToDeck(Deck deck) {
        this.decks.add(deck);
    }

    public Deck getDeckByName(String deckName) {
        for (Deck deck : decks) {
            if (deck.getName().equals(deckName)) {
                return deck;
            }
        }
        return null;
    }
}
