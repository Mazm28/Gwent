package server;

import Enums.SelectQuestionTexts;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import model.App;
import model.Deck;
import model.GameRecord;
import model.card.Card;
import model.card.LeaderCard;
import model.card.RegularCard;
import model.card.SpecialCard;

import java.io.Serializable;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {
    private static User loggedInUser;
    private static User tempUser;
    private final ArrayList<GameRecord> gameRecords = new ArrayList<>();
    private final ArrayList<Deck> decks = new ArrayList<>();
    private final ArrayList<Card> allCards = new ArrayList<>();
    private String username;
    private String password;
    private int rank = 0;
    private String email;
    private String nickname;
    private SelectQuestionTexts selectQuestionTexts;
    private String answer;
    private int id;
    private boolean remembered = false;
    private String token;
    private int wins = 0;
    private int loses = 0;
    private int draws = 0;

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public User(User user) {
        this.username = user.username;
        this.password = user.password;
        this.email = user.email;
        this.nickname = user.nickname;
        this.id = user.id;
    }

    public User() {
    }

    public User(String username, String password, String email, String nickname) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.id = App.getUsers().size();
    }

    public static User getTempUser() {
        return tempUser;
    }

    public static void setTempUser(User tempUser) {
        User.tempUser = tempUser;
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

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public boolean isRemembered() {
        return remembered;
    }

    public void setRemembered(boolean remembered) {
        this.remembered = remembered;
    }

    public int usersHighestScore() {
        int point = 0;
        for (GameRecord gameRecord : gameRecords) {
            if (gameRecord.finalPoints()[0] > point) point = gameRecord.finalPoints()[0];
        }
        return point;
    }

    public int getId() {
        return id;
    }

    public void makeAllCards() {
        allCards.addAll(RegularCard.makeCards());
        allCards.addAll(SpecialCard.makeCards());
        allCards.addAll(LeaderCard.makeCards());
    }

    public void removeCard(Card card) {
        allCards.remove(allCards.indexOf(card));
    }

    public void addToAllCards(Card card) {
        allCards.add(card);
    }
    public void addToAllCards(int place,Card card) {
        allCards.add(place,card);
    }

    public ArrayList<Card> getAllCards() {
        return allCards;
    }

    public void addToGameRecords(GameRecord gameRecord) {
        this.gameRecords.add(gameRecord);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public SelectQuestionTexts getSelectQuestionTexts() {
        return selectQuestionTexts;
    }

    public void setSelectQuestionTexts(SelectQuestionTexts selectQuestionTexts) {
        this.selectQuestionTexts = selectQuestionTexts;
    }

    public void setWinsAndLoses(){
        int wins = 0;
        int loses = 0;
        int draws = 0;
        for (GameRecord gameRecord: this.getGameRecords()){
            if(gameRecord.winner() == null) draws++;
            else if(gameRecord.winner().getUsername().equals(this.username)) wins++;
            else {
                loses++;
            }
        }
        this.setWins(wins);
        this.setLoses(loses);
        this.setDraws(draws);
    }

    public void makeRank(){
        ArrayList<User> users = new ArrayList<>(App.getUsers());
        System.out.println(users.size());
        for(int i=0;i<users.size();i++){
            users.get(i).setWinsAndLoses();
            for(int j=0;j<i;j++){
                if(users.get(j).getWins() < users.get(i).getWins()){
                    User tmp = users.get(i);
                    users.set(i,users.get(j));
                    users.set(j,tmp);
                }
            }
        }
        for(User user: users){
            if(user.username.equals(this.username)){
                rank = (users.indexOf(user) + 1);
            }
        }
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public ArrayList<GameRecord> getGameRecords() {
        return gameRecords;
    }

    public void addToDecks(Deck deck) {
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
