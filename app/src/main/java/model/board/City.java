package model.board;

import java.util.HashMap;
import java.util.HashSet;

import enums.CityName;
import enums.DiseaseType;

/**
 * Created by brandt on 5/14/15.
 */
public class City {

    private String name;
    private int population;

    private int protectionLevel = 0;
    private boolean outbreakFlag = false;
    private DiseaseType type;
    private HashMap<DiseaseType, Integer> infectionLevel = new HashMap<DiseaseType, Integer>();
    private HashSet<City> neighbors = new HashSet<City>();
    private HashSet<CityName> neighborNames = new HashSet<CityName>();

    public City(DiseaseType type) {
        this.type = type;

        initInfectionLevel();
    }

    public City(String name, int population, DiseaseType type) {
        this.name = name;
        this.population = population;
        this.type = type;

        initInfectionLevel();
    }

    private void initInfectionLevel() {
        infectionLevel.put(DiseaseType.BLUE, 0);
        infectionLevel.put(DiseaseType.YELLOW, 0);
        infectionLevel.put(DiseaseType.RED, 0);
        infectionLevel.put(DiseaseType.BLACK, 0);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }


}
