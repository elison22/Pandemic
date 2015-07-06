package model.card.type;

import enums.CityName;

/**
 * Created by brandt on 5/13/15.
 */
public class InfectionCard {

    CityName city;

    public InfectionCard(CityName city) {
        this.city = city;
    }

    public CityName getCity() {
        return city;
    }
}
