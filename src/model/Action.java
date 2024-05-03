package model;

public interface Action {
    public static void executeCommanderHorn(Game game, int row) {

    }
    public static void executeDecoy (Game game, Card targetCard) {

    }

    public static void executeMedic(Game game, Card card) {

    }

    public static void executeMoralBoost(Game game, int row) {

    }

    public static void executeMuster(Game game) {

    }

    public static void executeSpy(Game game) {

    }

    public static void executeTightBond(Game game, int row) {

    }

    public static void executeScorchCard(Game game) {
        //for Scorch card itself this method applies for whole board
    }

    public static void executeScorch(Game game) {
        //for other cards with this ability it applies for enemy's rows
    }

    public static void executeBerserker(Game game) {

    }

    public static void executeMardroeme(Game game, int row) {

    }

    public static void executeTransformers(Game game) {

    }

    public static void executeBitingFrost(Game game) {

    }

    public static void executeImpenetrablefog(Game game) {

    }

    public static void executeTorrentialRain(Game game) {

    }
}
