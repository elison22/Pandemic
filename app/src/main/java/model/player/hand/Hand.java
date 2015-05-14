package model.player.hand;

import java.util.ArrayList;

import model.cards.types.CityCard;
import model.cards.types.EventCard;
import model.cards.types.PlayerCard;

/**
 * Created by brandt on 5/14/15.
 */
public class Hand {

    ArrayList<CityCard> cityCards = new ArrayList<CityCard>();
    ArrayList<EventCard> eventCards = new ArrayList<EventCard>();
    ArrayList<PlayerCard> otherCards = new ArrayList<PlayerCard>();

}
