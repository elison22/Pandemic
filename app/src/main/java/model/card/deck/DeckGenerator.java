package model.card.deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import enums.CityName;
import model.board.City;
import model.card.type.CityCard;
import model.card.type.IPlayerCard;
import model.card.type.InfectionCard;

/**
 * Created by Chad on 6/27/2015.
 *
 * When this class is created a map of cities must be passed in through the constructor. The class
 * will then automatically generate player cards and infection cards which can be retrieved through
 * getPlayerDeck() and getInfectionDeck(), respectively.
 */
public class DeckGenerator {

    private Map<CityName, City> cities;

    private ArrayList<IPlayerCard> playerDeck;
    private ArrayList<InfectionCard> infectionDeck;

    public DeckGenerator(Map<CityName, City> cities) throws EmtpyCityListException {
        if (cities.size() < 1)
            throw new EmtpyCityListException();

        this.cities = cities;
        this.playerDeck = new ArrayList<>();
        this.infectionDeck = new ArrayList<>();

        generateDecks();
    }

    /*
     * Generate player CityCards and infection cards for each city in a given list of cities.
     */
    private void generateDecks() {

        // Generate player and infection cards
        for (Map.Entry<CityName, City> entry : cities.entrySet()) {
            CityName key = entry.getKey();
            City value = entry.getValue();
            playerDeck.add(new CityCard(key, value.getPopulation()));
            infectionDeck.add(new InfectionCard(key));
        }
    }

    public List<IPlayerCard> getPlayerDeck() {
        return playerDeck;
    }

    public List<InfectionCard> getInfectionDeck() { return infectionDeck; }

    /*
     * FOR TESTING
     */
    public Map<CityName, City> getCities() {
        return cities;
    }
}
