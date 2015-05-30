package model.card.type;

import enums.GameCardType;

/**
 * Created by brandt on 5/13/15.
 */
public abstract class GameCard {

    GameCardType type;
    boolean inPlay = true;
    boolean discarded = false;

    public GameCardType getType() {
        return type;
    }
    public void setType(GameCardType type) {
        this.type = type;
    }

}
