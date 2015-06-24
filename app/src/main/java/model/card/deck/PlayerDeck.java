package model.card.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import enums.CityName;
import enums.EventCardType;
import enums.GameDifficulty;
import model.GameLostException;
import model.card.type.CityCard;
import model.card.type.EpidemicCard;
import model.card.type.EventCard;
import model.card.type.IPlayerCard;

/**
 * Created by brandt on 5/13/15.
 */
public class PlayerDeck {

    private ArrayList<IPlayerCard> drawPile;
    private ArrayList<IPlayerCard> discardPile;

    public PlayerDeck() {

        drawPile = new ArrayList<IPlayerCard>();
        drawPile.add(new CityCard(CityName.MADRID, 5427));
        drawPile.add(new CityCard(CityName.ATLANTA, 4715));
        drawPile.add(new CityCard(CityName.ST_PETERSBURG, 4879));
        drawPile.add(new CityCard(CityName.MONTREAL, 3429));
        drawPile.add(new CityCard(CityName.SAN_FRANCISCO, 5864));
        drawPile.add(new CityCard(CityName.LONDON, 8586));
        drawPile.add(new CityCard(CityName.CHICAGO, 9121));
        drawPile.add(new CityCard(CityName.PARIS, 10755));
        drawPile.add(new CityCard(CityName.MILAN, 5232));
        drawPile.add(new CityCard(CityName.WASHINGTON, 4679));
        drawPile.add(new CityCard(CityName.NEW_YORK, 20464));
        drawPile.add(new CityCard(CityName.ESSEN, 575));

        drawPile.add(new CityCard(CityName.MIAMI, 5582));
        drawPile.add(new CityCard(CityName.LIMA, 9121));
        drawPile.add(new CityCard(CityName.SAO_PAULO, 20186));
        drawPile.add(new CityCard(CityName.BOGOTA, 8702));
        drawPile.add(new CityCard(CityName.JOHANNESBURG, 3888));
        drawPile.add(new CityCard(CityName.BUENOS_AIRES, 13639));
        drawPile.add(new CityCard(CityName.SANTIAGO, 6015));
        drawPile.add(new CityCard(CityName.KHARTOUM, 4887));
        drawPile.add(new CityCard(CityName.MEXICO_CITY, 19463));
        drawPile.add(new CityCard(CityName.LAGOS, 11547));
        drawPile.add(new CityCard(CityName.KINSHASA, 9046));
        drawPile.add(new CityCard(CityName.LOS_ANGELES, 14900));

        drawPile.add(new CityCard(CityName.CAIRO, 14718));
        drawPile.add(new CityCard(CityName.MOSCOW, 15512));
        drawPile.add(new CityCard(CityName.MUMBAI, 16910));
        drawPile.add(new CityCard(CityName.CHENNAI, 8865));
        drawPile.add(new CityCard(CityName.DELHI, 22242));
        drawPile.add(new CityCard(CityName.ALGIERS, 2946));
        drawPile.add(new CityCard(CityName.TEHRAN, 7419));
        drawPile.add(new CityCard(CityName.KOLKATA, 14374));
        drawPile.add(new CityCard(CityName.BAGHDAD, 6204));
        drawPile.add(new CityCard(CityName.KARACHI, 20711));
        drawPile.add(new CityCard(CityName.RIYADH, 5037));
        drawPile.add(new CityCard(CityName.ISTANBUL, 13576));

        drawPile.add(new CityCard(CityName.MANILA, 20767));
        drawPile.add(new CityCard(CityName.JAKARTA, 26063));
        drawPile.add(new CityCard(CityName.TOKYO, 13189));
        drawPile.add(new CityCard(CityName.SEOUL, 22547));
        drawPile.add(new CityCard(CityName.OSAKA, 2871));
        drawPile.add(new CityCard(CityName.BEIJING, 17311));
        drawPile.add(new CityCard(CityName.HO_CHI_MINH_CITY, 8314));
        drawPile.add(new CityCard(CityName.SYDNEY, 3785));
        drawPile.add(new CityCard(CityName.BANGKOK, 7151));
        drawPile.add(new CityCard(CityName.SHANGHAI, 13482));
        drawPile.add(new CityCard(CityName.TAIPEI, 8338));
        drawPile.add(new CityCard(CityName.HONG_KONG, 7106));

        drawPile.add(new EventCard(EventCardType.QUIETNIGHT,
                "Skip the next Infect Cities step\n" +
                        "(do not flip over any Infection cards)."));
        drawPile.add(new EventCard(EventCardType.GOVGRANT,
                "Add 1 research station to any city\n" +
                        "(no City card needed)."));
        drawPile.add(new EventCard(EventCardType.FORECAST,
                "Draw, look at, and rearrange the top 6 cards of the Infection Deck\n" +
                        "Put them back on top."));
        drawPile.add(new EventCard(EventCardType.RESILPOP,
                "Remove any 1 card in the Infection Discard Pile from the game.\n" +
                        "You may play this between the Infect and Intensify steps of an Epidemic."));
        drawPile.add(new EventCard(EventCardType.AIRLIFT,
                "Move any 1 pawn to any city.\n" +
                        "Get permission before moving another player's pawn."));

        Collections.shuffle(drawPile);

    }

    public IPlayerCard drawCard() throws GameLostException {

        if (drawPile.size() == 0)
            throw new GameLostException();
        IPlayerCard toReturn = drawPile.get(0);
        drawPile.remove(0);
        return toReturn;

    }

    public void discardCard(IPlayerCard card) {
        discardPile.add(card);
    }

    public void addEpidemicCards(GameDifficulty difficulty) {

        Random rand = new Random();
        int epidCount = GameDifficulty.getEpidemicCardCount(difficulty);
        int extraCount = discardPile.size() / epidCount;
        int baseGroupSize = discardPile.size() % epidCount;
        int curIndex = 0;

        for(int i = 0; i < epidCount; i++) {

            int groupSize = baseGroupSize;
            if(extraCount > 0) {
                groupSize++;
                extraCount--;
            }

            int epicLoc = rand.nextInt(groupSize);
            drawPile.add(curIndex + epicLoc, new EpidemicCard());
            curIndex += groupSize + 1;
        }

    }

}
