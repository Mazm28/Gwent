package controller;

import Enums.Faction;
import model.App;
import model.CardCollection;
import model.Game;
import model.Row;
import model.card.*;
import view.FactionsMenu;
import view.GameMenu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ActionController {
    static Game game = App.getGame();

    public static Runnable CommanderHorn() {
        return () -> {
            for (Row row : game.getCurrentPlayer().getRows()) {
                if (row.getImproveCard().getName().equals(SpecialCardInformation.Commander_Horn.getName())) {
                    for (Card card : row.getCards()) {
                        card.setPower(card.getPower() * 2);
                    }
                }
                for (Card card : row.getCards()) {
                    if (card.getAbility().equals(ActionController.CommanderHorn())) {
                        for (Card card1 : row.getCards()) {
                            if (!card.equals(card1)) {
                                card1.setPower(card.getPower() * 2);
                            }
                        }
                        break;
                    }
                }

            }
        };
    }

    public static Runnable Medic() {
        return () -> {
            ArrayList<Card> buriedCards = game.getCurrentPlayer().getBurnedCards();
            Random rand = new Random();
            int randomIndex = rand.nextInt(buriedCards.size());
            Card newCard = buriedCards.get(randomIndex);
            ArrayList<Card> newHand = game.getCurrentPlayer().getInGameHand();
            newHand.add(newCard);
            game.getCurrentPlayer().setInGameHand(newHand);
            buriedCards.remove(newCard);
            game.getCurrentPlayer().setBuriedCards(buriedCards);
        };
    }

    public static Runnable MoralBoost() {
        return () -> {
            for (Row row : game.getCurrentPlayer().getRows()) {
                for (Card card : row.getCards()) {
                    if (card.getAbility().equals(ActionController.CommanderHorn())) {
                        for (Card card1 : row.getCards()) {
                            if (!card.equals(card1)) {
                                card1.setPower(card.getPower() * 2);
                            }
                        }
                        break;
                    }
                }
            }
        };
    }

    public static Runnable Muster() {
        return new Runnable() {
            @Override
            public void run() {
                int index = getIndex(((SpecialCard) game.getAction()).getType());
                for (Card card : game.getCurrentPlayer().getInGameHand()) {
                    if (card.getName().equals(game.getAction().getName())) {
                        game.getCurrentPlayer().getRows()[index].addCardToCards(card);
                    }
                }
                for (Card card : game.getCurrentPlayer().getRemainCard()) {
                    if (card.getName().equals(game.getAction().getName())) {
                        game.getCurrentPlayer().getRows()[index].addCardToCards(card);
                    }
                }
            }
        };
    }

    private static int getIndex(String type) {
        return switch (type) {
            case "Close" -> 2;
            case "Ranged" -> 1;
            case "Siege" -> 0;
            default -> -1;
        };
    }

    public static Runnable Spy() {
        return new Runnable() {
            @Override
            public void run() {
                Random rand = new Random();
                int index = rand.nextInt(game.getCurrentPlayer().getRemainCard().size());
                game.getCurrentPlayer().addToInGameHand(game.getCurrentPlayer().getRemainCard().get(index));
                game.getCurrentPlayer().getRemainCard().remove(index);
                index = rand.nextInt(game.getCurrentPlayer().getRemainCard().size());
                game.getCurrentPlayer().addToInGameHand(game.getCurrentPlayer().getRemainCard().get(index));
                game.getCurrentPlayer().getRemainCard().remove(index);
            }
        };
    }

    public static Runnable TightBond() {
        return () -> {
            int numOfCards = 0;
            Row row = new Row();
            for (Row row1 : game.getRows()) {
                for (Card card : row1.getCards()) {
                    if (card.getAbility().equals(ActionController.TightBond())) {
                        row = row1;
                        break;
                    }
                }
            }
            for (Card card : row.getCards()) {
                if (card.getAbility().equals(ActionController.TightBond()))
                    numOfCards++;
            }
            for (Card card : row.getCards()) {
                if (card.getAbility().equals(ActionController.TightBond()))
                    card.setPower(card.getPower() * numOfCards);
            }

        };
    }

    public static Runnable ScorchCard() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable Scorch() {
        return new Runnable() {
            @Override
            public void run() {
                ArrayList<Card> cards = new ArrayList<>();
                for (Row row : game.getRows()) {
                    cards.addAll(row.getCards());
                }
                Card mostPowered = CardCollection.getMostPowered(cards);
                for (Row row : game.getRows()) {
                    row.getCards().removeIf(card -> card.getPower() == mostPowered.getPower());
                }
            }
        };
    }

    public static Runnable Berserker() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable Mardroeme() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable Transformers() {
        return () -> {
            for (Row row : game.getCurrentPlayer().getRows()) {
                for (Card card : row.getCards()) {
                    if (card.getAbility().equals(ActionController.Transformers()))
                        card.setPower(8);
                }
            }
        };
    }

    public static Runnable BitingFrost() {
        return () -> {
            fuckRow(2);
            fuckRow(3);
        };
    }

    private static void fuckRow(int index) {
        for (Card card : game.getRows()[index].getCards()) {
            if (card instanceof RegularCard) {
                if (!((RegularCard) card).isHero()) {
                    card.setPower(1);
                }
            }
        }

        for (Card card : game.getRows()[index].getCards()) {
            if (card instanceof SpecialCard) {
                if (!((SpecialCard) card).isHero() && !((SpecialCard) card).getType().equals("Spell") && !((SpecialCard) card).getType().equals("Weather")) {
                    card.setPower(1);
                }
            }
        }
    }

    public static Runnable ImpenetrableFog() {
        return new Runnable() {
            @Override
            public void run() {
                fuckRow(1);
                fuckRow(4);
            }
        };
    }

    public static Runnable TorrentialRain() {
        return new Runnable() {
            @Override
            public void run() {
                fuckRow(0);
                fuckRow(5);
            }
        };
    }

    public static Runnable SkelligeStorm() {
        return new Runnable() {
            @Override
            public void run() {
                TorrentialRain().run();
                ImpenetrableFog().run();
            }
        };
    }

    public static Runnable ClearWeather() {
        return () -> {
            for (Row row : game.getRows()) {
                for (Card card : row.getCards()) {
                    if (card instanceof RegularCard) {
                        if (!((RegularCard) card).isHero()) {
                            card.setPower(((RegularCard) card).getRegularCardInformation().getPower());
                        }
                    }
                }
                for (Card card : row.getCards()) {
                    if (card instanceof SpecialCard) {
                        if (!((SpecialCard) card).isHero() && !((SpecialCard) card).getType().equals("Spell") && !((SpecialCard) card).getType().equals("Weather")) {
                            card.setPower(((SpecialCard) card).getSpecialCardInformation().getPower());
                        }
                    }
                }
            }
        };
    }

    public static Runnable Siegemaster() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable SteelForged() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable KingofTemeria() {
        return () -> {
            boolean isThereCommandersHorn = false;
            Row row = new Row();
            for (Row row1 : game.getCurrentPlayer().getRows()) {
                for (Card card : row1.getCards()) {
                    if (card.getAbility().equals(ActionController.KingofTemeria())) {
                        row = row1;
                        for (Card card1 : row1.getCards()) {
                            if (card1.getAbility().equals(ActionController.CommanderHorn())) {
                                isThereCommandersHorn = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (!isThereCommandersHorn) {
                for (Card card : row.getCards()) {
                    if (card.getCardType().equals("Siege"))
                        card.setPower(card.getPower() * 2);
                }
            }
        };
    }

    public static Runnable SonOfMedell() {
        return () -> {
            int powerOfRangedCards = 0;
            ArrayList<Card> cards = new ArrayList<>();
            for (Row row : game.getCurrentPlayer().getRows()) {
                for (Card card : row.getCards()) {
                    if (card.getCardType().equals("Ranged")) {
                        powerOfRangedCards += card.getPower();
                        cards.add(card);
                    }
                }
            }
            Card mostPowered = CardCollection.getMostPowered(cards);
            if (powerOfRangedCards > 10) {
                for (Row row : game.getCurrentPlayer().getRows()) {
                    for (Card card : row.getCards()) {
                        if (card.getPower() == mostPowered.getPower()) {
                            row.getCards().remove(card);
                            game.getCurrentPlayer().getBurnedCards().add(card);
                        }
                    }
                }
            }
        };
    }

    public static Runnable WhiteFlame() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable HisImperialMajesty() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable LordCommanderoftheNorth() {
        return () -> {
            int powerOfSiegeCards = 0;
            ArrayList<Card> cards = new ArrayList<>();
            for (Row row : game.getCurrentPlayer().getRows()) {
                for (Card card : row.getCards()) {
                    if (card.getCardType().equals("Siege")) {
                        powerOfSiegeCards += card.getPower();
                        cards.add(card);
                    }
                }
            }
            Card mostPowered = CardCollection.getMostPowered(cards);
            if (powerOfSiegeCards > 10) {
                for (Row row : game.getCurrentPlayer().getRows()) {
                    for (Card card : row.getCards()) {
                        if (card.getPower() == mostPowered.getPower()) {
                            row.getCards().remove(card);
                            game.getCurrentPlayer().getBurnedCards().add(card);
                        }
                    }
                }
            }
        };
    }

    public static Runnable EmperorOfNilfgaard() {
        return () -> {
            game.getOpponent().getLeader().setAbility(null);
        };
    }

    public static Runnable Relentless() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable InvaderoftheNorth() {
        return () -> {
            ArrayList<Card> myBurned = game.getCurrentPlayer().getBurnedCards();
            ArrayList<Card> opponentBurned = game.getOpponent().getBurnedCards();
            Collections.shuffle(myBurned);
            Collections.shuffle(opponentBurned);
            game.getCurrentPlayer().getInGameHand().add(myBurned.get(0));
            game.getOpponent().getInGameHand().add(opponentBurned.get(0));
            game.getCurrentPlayer().getBurnedCards().remove(myBurned.get(0));
            game.getOpponent().getBurnedCards().remove(opponentBurned.get(0));
        };
    }

    public static Runnable BringerOfDeath() {
        return () -> {
            boolean isThereCommandersHorn = false;
            Row goalRow = new Row();
            for (Row row : game.getCurrentPlayer().getRows()) {
                for (Card card : row.getCards()) {
                    if (card.getAbility().equals(ActionController.BringerOfDeath())) {
                        goalRow = row;
                        for (Card card1 : row.getCards()) {
                            if (card1.getAbility().equals(ActionController.CommanderHorn()))
                                isThereCommandersHorn = true;
                            break;
                        }
                        break;
                    }
                }
            }
            if (!isThereCommandersHorn) {
                for (Card card : goalRow.getCards()) {
                    if (card.getCardType().equals("Close"))
                        card.setPower(card.getPower() * 2);
                }
            }
        };
    }

    public static Runnable KingOfthewildHunt() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable DestroyerOfWorlds() {
        return new Runnable() {
            @Override
            public void run() {
            }
        };
    }

    public static Runnable CommanderOfTheRedRiders() {
        return new Runnable() {
            @Override
            public void run() {
            }
        };
    }

    public static Runnable Treacherous() {
        return () -> {
            for (Row row : game.getCurrentPlayer().getRows()) {
                for (Card card : row.getCards()) {
                    if (card.getAbility().equals(ActionController.Spy()))
                        card.setPower(card.getPower() * 2);
                }
            }
            for (Row row : game.getOpponent().getRows()) {
                for (Card card : row.getCards()) {
                    if (card.getAbility().equals(ActionController.Spy()))
                        card.setPower(card.getPower() * 2);
                }
            }
        };
    }

    public static Runnable QueenOfDolBlathanna() {
        return () -> {
            int powerOfRangedCards = 0;
            ArrayList<Card> cards = new ArrayList<>();
            for (Row row : game.getCurrentPlayer().getRows()) {
                for (Card card : row.getCards()) {
                    if (card.getCardType().equals("Close"))
                        powerOfRangedCards += card.getPower();
                    if (card.getCardType().equals("Ranged"))
                        cards.add(card);

                }
            }
            Card mostPowered = CardCollection.getMostPowered(cards);
            if (powerOfRangedCards > 10) {
                for (Row row : game.getCurrentPlayer().getRows()) {
                    for (Card card : row.getCards()) {
                        if (card.getPower() == mostPowered.getPower()) {
                            row.getCards().remove(card);
                            game.getCurrentPlayer().getBurnedCards().add(card);
                        }
                    }
                }
            }
        };
    }

    public static Runnable Beautiful() {
        return () -> {
            boolean isThereCommandersHorn = false;
            Row goalRow = new Row();
            for (Row row : game.getCurrentPlayer().getRows()) {
                for (Card card : row.getCards()) {
                    if (card.getAbility().equals(ActionController.BringerOfDeath())) {
                        goalRow = row;
                        for (Card card1 : row.getCards()) {
                            if (card1.getAbility().equals(ActionController.CommanderHorn()))
                                isThereCommandersHorn = true;
                            break;
                        }
                        break;
                    }
                }
            }
            if (!isThereCommandersHorn) {
                for (Card card : goalRow.getCards()) {
                    if (card.getCardType().equals("Ranged"))
                        card.setPower(card.getPower() * 2);
                }
            }
        };
    }

    public static Runnable DaisyOfTheValley() {
        return () -> {
            Card card = new RegularCard(RegularCardInformation.IORVETH);
            game.getCurrentPlayer().getRemainCard().add(card);
        };
    }

    public static Runnable PurebloodElf() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable HopeOfTheAenSeidhe() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable CrachanCraite() {
        return () -> {
            Collections.shuffle(game.getCurrentPlayer().getBurnedCards());
            game.getCurrentPlayer().getInGameHand().addAll(game.getCurrentPlayer().getBurnedCards());
            Collections.shuffle(game.getOpponent().getBurnedCards());
            game.getOpponent().getInGameHand().addAll(game.getOpponent().getBurnedCards());
        };
    }

    public static Runnable KingBran() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable Monsters() {
        return () -> {
            ArrayList<Card> onTableCards = new ArrayList<>();
            for(Row row : game.getCurrentPlayer().getRows()){
                onTableCards.addAll(row.getCards());

            }
            Collections.shuffle(onTableCards);
            Card card = onTableCards.getFirst();
            game.getCurrentPlayer().getRemainCard().add(card);
        };
    }


    public static void cowTransform(SpecialCard card) {
        card.setImageAddress("/IMAGES/lg/scoiatael_schirru.jpg");
        card.setPower(8);
    }
}
