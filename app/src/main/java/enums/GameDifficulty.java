package enums;

/**
 * Created by brandt on 6/23/15.
 */
public enum GameDifficulty {

    NOVICE, STANDARD, HEROIC;

    public static int getEpidemicCardCount(GameDifficulty difficulty) {

        switch (difficulty) {
            case NOVICE:
                return 4;
            case STANDARD:
                return 5;
            case HEROIC:
                return 6;
            default:
                return 4;
        }
    }

}
