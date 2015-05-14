package model.player;

import model.card.type.PlayerCard;
import model.city.City;
import model.player.hand.Hand;
import model.player.role.IRole;
import strategy.framework.player.other.IDiscardStrategy;

/**
 * Created by brandt on 5/14/15.
 */
public class Player /*implements IPlayer*/{

    int playerId;
    String playerName;
    IRole role; //maybe we can just do a concrete role?
    City location;
    Hand hand = new Hand();

    public Player(IRole role, int playerId, String playerName) {

        this.role = role;
        this.playerId = playerId;
        this.playerName = playerName;

    }


    public boolean checkDiscard(IDiscardStrategy discardStrategy){
        return false;
    }

    public boolean discardCard(IDiscardStrategy discardStrategy, PlayerCard card){
        return false;
    }

    //moving
    //building a research station
    //



}
