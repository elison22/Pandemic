package model.city;

import java.util.HashMap;

import model.player.Player;
import shared.DiseaseType;

/**
 * Created by brandt on 5/14/15.
 */
public class City {

    DiseaseType type;
    HashMap<DiseaseCube, Integer> infectionLevel = new HashMap<DiseaseCube, Integer>();



}
