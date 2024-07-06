package controller;

import model.App;
import model.CardCollection;
import model.Game;
import model.Row;
import model.card.*;
import view.GameMenu;

import java.util.ArrayList;
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
                index = rand.nextInt(game.getCurrentPlayer().getRemainCard().size());
                game.getCurrentPlayer().addToInGameHand(game.getCurrentPlayer().getRemainCard().get(index));
            }
        };
    }

    public static Runnable TightBond() {
        return () -> {
            int numOfCards = 0;
            Row row = new Row();
            for(Row row1 : game.getRows()){
                for(Card card : row1.getCards()){
                    if(card.getAbility().equals(ActionController.TightBond())) {
                        row = row1;
                        break;
                    }
                }
            }
            for(Card card : row.getCards()){
                if(card.getAbility().equals(ActionController.TightBond()))
                    numOfCards ++;
            }
            for(Card card : row.getCards()){
                if(card.getAbility().equals(ActionController.TightBond()))
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
        return new Runnable() {
            @Override
            public void run() {

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
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable SonOfMedell() {
        return new Runnable() {
            @Override
            public void run() {

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
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable EmperorOfNilfgaard() {
        return new Runnable() {
            @Override
            public void run() {

            }
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
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable BringerOfDeath() {
        return new Runnable() {
            @Override
            public void run() {

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
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable QueenOfDolBlathanna() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable Beautiful() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable DaisyOfTheValley() {
        return new Runnable() {
            @Override
            public void run() {

            }
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
        return new Runnable() {
            @Override
            public void run() {

            }
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
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }


    public static void cowTransform(SpecialCard card) {
        card.setImageAddress("/IMAGES/lg/scoiatael_schirru.jpg");
        card.setPower(8);
    }
}
