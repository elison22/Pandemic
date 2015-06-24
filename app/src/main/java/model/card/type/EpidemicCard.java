package model.card.type;

import enums.PlayerCardType;

/**
 * Created by brandt on 6/23/15.
 */
public class EpidemicCard implements IPlayerCard {

    @Override
    public PlayerCardType getType() {
        return PlayerCardType.EPIDEMIC;
    }
}
