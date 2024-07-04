package controller;

import model.App;
import model.Game;
import model.Row;
import model.card.Card;
import model.card.SpecialCardInformation;

public class ActionController {
    static Game game = App.getGame();

    public static Runnable CommanderHorn() {
        return new Runnable() {
            @Override
            public void run() {
                for (Row row : game.getCurrentPlayer().getRows()) {
                    if (row.getImproveCard().getName().equals(SpecialCardInformation.Commander_Horn.getName())) {
                        for (Card card : row.getCards()) {
                            card.setPower(card.getPower() * 2);
                        }
                    }
                    for (Card card : row.getCards()) {
                        if (card.getAbility().equals(ActionController.CommanderHorn())) {
                            for(Card card1: row.getCards()){
                                if(!card.equals(card1)) {
                                    card1.setPower(card.getPower() * 2);
                                }
                            }
                            break;
                        }
                    }

                }
            }
        };
    }

    public static Runnable Decoy() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable Medic() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable MoralBoost() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable Muster() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable Spy() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable TightBond() {
        return new Runnable() {
            @Override
            public void run() {

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
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable Impenetrablefog() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable TorrentialRain() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable SkelligeStorm() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static Runnable ClearWeather() {
        return new Runnable() {
            @Override
            public void run() {

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


}
