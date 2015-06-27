package test.model.deck;

import java.util.HashMap;
import java.util.List;

import enums.CityName;
import enums.DiseaseType;
import model.board.City;
import model.card.deck.DeckGenerator;
import model.card.deck.EmtpyCityListException;
import model.card.type.CityCard;
import model.card.type.IPlayerCard;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Chad on 6/27/2015.
 */
public class DeckGeneratorTest {

    private DeckGenerator deckGenerator;

    public DeckGeneratorTest() {
    }

    public void testSimpleCityList() {
        HashMap<CityName, City> cities = new HashMap<>();

        cities.put(CityName.ALGIERS, new City("Algiers", 1234, DiseaseType.BLACK));
        cities.put(CityName.ATLANTA, new City("Atlanta", 555, DiseaseType.BLUE));
        cities.put(CityName.LONDON, new City("London", 9001, DiseaseType.BLUE));

        try {
            deckGenerator = new DeckGenerator(cities);

            assertNotNull(deckGenerator.getCities());
            assertTrue(deckGenerator.getCities().size() == 3);

            List<IPlayerCard> cards = deckGenerator.getPlayerDeck();
            assertNotNull(cards);
            assertFalse(cards.isEmpty());
            assertTrue(cards.size() == 3);

            CityCard card = (CityCard) cards.get(0);
            assertTrue(card.getCity().equals(CityName.ALGIERS));
            assertTrue(card.getPopulation() == 1234000);

            card = (CityCard) cards.get(1);
            assertTrue(card.getCity().equals(CityName.ATLANTA));
            assertTrue(card.getPopulation() == 555000);

            card = (CityCard) cards.get(2);
            assertTrue(card.getCity().equals(CityName.LONDON));
            assertTrue(card.getPopulation() == 9001000);

        } catch (EmtpyCityListException e) {
            e.printStackTrace();
        }
    }
}
