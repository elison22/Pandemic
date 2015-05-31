package model.board;

import java.util.HashMap;
import java.util.HashSet;

import enums.CityName;
import enums.DiseaseType;

/**
 * Created by brandt on 5/14/15.
 */
public class City {

    private int protectionLevel = 0;
    private boolean outbreakFlag = false;
    private DiseaseType type;
    private HashMap<DiseaseType, Integer> infectionLevel = new HashMap<DiseaseType, Integer>();
    private HashSet<City> neighbors = new HashSet<City>();
    private HashSet<CityName> neighborNames = new HashSet<CityName>();

    public City(DiseaseType type) {
        this.type = type;
    }

    public void addNeighbor(City city) {
        neighbors.add(city);
    }

    public void addNeighbor(CityName city) {
        neighborNames.add(city);
    }

    public int getDiseaseCount(DiseaseType type) {
        return infectionLevel.get(type);
    }

    public HashSet<CityName> getNeighbors() {
        return neighborNames;
    }

    public void addDisease(DiseaseType type) {
        infectionLevel.put(type, infectionLevel.get(type) + 1);
    }

    public void setOutbreakFlag(boolean flag) {
        outbreakFlag = flag;
    }

    public boolean getOutbreakFlag() {
        return outbreakFlag;
    }

    public void adjustProtection(int amount) {
        protectionLevel+=amount;
    }

    public boolean isProtected() {
        return protectionLevel > 0;
    }

    public DiseaseType getDiseaseType() {
        return type;
    }


}
