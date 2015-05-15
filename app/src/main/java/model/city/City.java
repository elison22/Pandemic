package model.city;

import java.util.HashMap;
import java.util.HashSet;

import enums.DiseaseType;

/**
 * Created by brandt on 5/14/15.
 */
public class City {

    DiseaseType type;
    HashMap<DiseaseCube, Integer> infectionLevel = new HashMap<DiseaseCube, Integer>();
    HashSet<City> neighbors = new HashSet<City>();

    public City(DiseaseType type) {
        this.type = type;
    }

    public void addNeighbor(City city) {
        neighbors.add(city);
    }

}
