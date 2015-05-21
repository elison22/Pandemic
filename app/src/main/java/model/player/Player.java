package model.player;

import model.card.type.PlayerCard;
import model.city.City;
import strategy.framework.player.turn.IDiscardStrategy;

/**
 * Created by brandt on 5/14/15.
 */
public class Player {

    private int playerId;
    private String playerName;
    private City location;
    private Hand hand = new Hand();

    public Player(int playerId, String playerName) {

        this.playerId = playerId;
        this.playerName = playerName;

    }


    public boolean checkIfShouldDiscard(IDiscardStrategy discardStrategy){
        return false;
    }

    public boolean discardCard(IDiscardStrategy discardStrategy, PlayerCard card){
        return false;
    }




    //moving
    //building a research station
    //



}
