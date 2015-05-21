package model.player;

import java.util.ArrayList;

import model.card.type.CityCard;
import model.card.type.EventCard;
import model.card.type.PlayerCard;

/**
 * Created by brandt on 5/14/15.
 */
public class Hand {

    ArrayList<CityCard> cityCards = new ArrayList<CityCard>();
    ArrayList<EventCard> eventCards = new ArrayList<EventCard>();
    ArrayList<PlayerCard> otherCards = new ArrayList<PlayerCard>();

}
