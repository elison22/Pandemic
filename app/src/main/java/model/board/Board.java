package model.board;

import java.util.HashMap;

import model.city.City;
import shared.CityName;
import shared.DiseaseType;

/**
 * Created by brandt on 5/14/15.
 */
public class Board {

    HashMap<CityName, City> cities = new HashMap<CityName, City>();

    public Board()
    {
        createCities();
        addBlueNeighbors();
        addYellowNeighbors();
        addBlackNeighbors();
        addRedNeighbors();
    }

    private void createCities() {
        // blue
        cities.put(CityName.SAN_FRANCISCO, new City(DiseaseType.BLUE));
        cities.put(CityName.CHICAGO, new City(DiseaseType.BLUE));
        cities.put(CityName.ATLANTA, new City(DiseaseType.BLUE));
        cities.put(CityName.MONTREAL, new City(DiseaseType.BLUE));
        cities.put(CityName.NEW_YORK, new City(DiseaseType.BLUE));
        cities.put(CityName.WASHINGTON, new City(DiseaseType.BLUE));
        cities.put(CityName.LONDON, new City(DiseaseType.BLUE));
        cities.put(CityName.MADRID, new City(DiseaseType.BLUE));
        cities.put(CityName.PARIS, new City(DiseaseType.BLUE));
        cities.put(CityName.ESSEN, new City(DiseaseType.BLUE));
        cities.put(CityName.MILAN, new City(DiseaseType.BLUE));
        cities.put(CityName.ST_PETERSBURG, new City(DiseaseType.BLUE));

        // yellow
        cities.put(CityName.LOS_ANGELES, new City(DiseaseType.YELLOW));
        cities.put(CityName.MEXICO_CITY, new City(DiseaseType.YELLOW));
        cities.put(CityName.MIAMI, new City(DiseaseType.YELLOW));
        cities.put(CityName.BOGOTA, new City(DiseaseType.YELLOW));
        cities.put(CityName.LIMA, new City(DiseaseType.YELLOW));
        cities.put(CityName.SANTIAGO, new City(DiseaseType.YELLOW));
        cities.put(CityName.BUENOS_AIRES, new City(DiseaseType.YELLOW));
        cities.put(CityName.SAO_PAULO, new City(DiseaseType.YELLOW));
        cities.put(CityName.LAGOS, new City(DiseaseType.YELLOW));
        cities.put(CityName.KINSHASA, new City(DiseaseType.YELLOW));
        cities.put(CityName.KHARTOUM, new City(DiseaseType.YELLOW));
        cities.put(CityName.JOHANNESBURG, new City(DiseaseType.YELLOW));

        // black
        cities.put(CityName.ALGIERS, new City(DiseaseType.BLACK));
        cities.put(CityName.ISTANBUL, new City(DiseaseType.BLACK));
        cities.put(CityName.CAIRO, new City(DiseaseType.BLACK));
        cities.put(CityName.MOSCOW, new City(DiseaseType.BLACK));
        cities.put(CityName.BAGHDAD, new City(DiseaseType.BLACK));
        cities.put(CityName.RIYADH, new City(DiseaseType.BLACK));
        cities.put(CityName.TEHRAN, new City(DiseaseType.BLACK));
        cities.put(CityName.KARACHI, new City(DiseaseType.BLACK));
        cities.put(CityName.MUMBAI, new City(DiseaseType.BLACK));
        cities.put(CityName.DELHI, new City(DiseaseType.BLACK));
        cities.put(CityName.CHENNAI, new City(DiseaseType.BLACK));
        cities.put(CityName.KOLKATA, new City(DiseaseType.BLACK));

        // red
        cities.put(CityName.BEIJING, new City(DiseaseType.RED));
        cities.put(CityName.SEOUL, new City(DiseaseType.RED));
        cities.put(CityName.TOKYO, new City(DiseaseType.RED));
        cities.put(CityName.SHANGHAI, new City(DiseaseType.RED));
        cities.put(CityName.OSAKA, new City(DiseaseType.RED));
        cities.put(CityName.TAIPEI, new City(DiseaseType.RED));
        cities.put(CityName.HONG_KONG, new City(DiseaseType.RED));
        cities.put(CityName.BANGKOK, new City(DiseaseType.RED));
        cities.put(CityName.MANILA, new City(DiseaseType.RED));
        cities.put(CityName.HO_CHI_MINH_CITY, new City(DiseaseType.RED));
        cities.put(CityName.JAKARTA, new City(DiseaseType.RED));
        cities.put(CityName.SYDNEY, new City(DiseaseType.RED));
    }

    private void addBlueNeighbors() {
        // san fran
        cities.get(CityName.SAN_FRANCISCO).addNeighbor(cities.get(CityName.CHICAGO));
        cities.get(CityName.SAN_FRANCISCO).addNeighbor(cities.get(CityName.LOS_ANGELES));
        cities.get(CityName.SAN_FRANCISCO).addNeighbor(cities.get(CityName.TOKYO));
        cities.get(CityName.SAN_FRANCISCO).addNeighbor(cities.get(CityName.MANILA));

        // chicago
        cities.get(CityName.CHICAGO).addNeighbor(cities.get(CityName.SAN_FRANCISCO));
        cities.get(CityName.CHICAGO).addNeighbor(cities.get(CityName.LOS_ANGELES));
        cities.get(CityName.CHICAGO).addNeighbor(cities.get(CityName.MEXICO_CITY));
        cities.get(CityName.CHICAGO).addNeighbor(cities.get(CityName.ATLANTA));
        cities.get(CityName.CHICAGO).addNeighbor(cities.get(CityName.MONTREAL));

        // atlanta
        cities.get(CityName.ATLANTA).addNeighbor(cities.get(CityName.CHICAGO));
        cities.get(CityName.ATLANTA).addNeighbor(cities.get(CityName.WASHINGTON));
        cities.get(CityName.ATLANTA).addNeighbor(cities.get(CityName.MIAMI));

        // montreal
        cities.get(CityName.MONTREAL).addNeighbor(cities.get(CityName.CHICAGO));
        cities.get(CityName.MONTREAL).addNeighbor(cities.get(CityName.WASHINGTON));
        cities.get(CityName.MONTREAL).addNeighbor(cities.get(CityName.NEW_YORK));

        // washington
        cities.get(CityName.WASHINGTON).addNeighbor(cities.get(CityName.MIAMI));
        cities.get(CityName.WASHINGTON).addNeighbor(cities.get(CityName.ATLANTA));
        cities.get(CityName.WASHINGTON).addNeighbor(cities.get(CityName.MONTREAL));
        cities.get(CityName.WASHINGTON).addNeighbor(cities.get(CityName.NEW_YORK));

        // new york
        cities.get(CityName.NEW_YORK).addNeighbor(cities.get(CityName.WASHINGTON));
        cities.get(CityName.NEW_YORK).addNeighbor(cities.get(CityName.MONTREAL));
        cities.get(CityName.NEW_YORK).addNeighbor(cities.get(CityName.MADRID));
        cities.get(CityName.NEW_YORK).addNeighbor(cities.get(CityName.LONDON));

        // madrid
        cities.get(CityName.MADRID).addNeighbor(cities.get(CityName.NEW_YORK));
        cities.get(CityName.MADRID).addNeighbor(cities.get(CityName.LONDON));
        cities.get(CityName.MADRID).addNeighbor(cities.get(CityName.SAO_PAULO));
        cities.get(CityName.MADRID).addNeighbor(cities.get(CityName.PARIS));
        cities.get(CityName.MADRID).addNeighbor(cities.get(CityName.ALGIERS));

        // london
        cities.get(CityName.LONDON).addNeighbor(cities.get(CityName.NEW_YORK));
        cities.get(CityName.LONDON).addNeighbor(cities.get(CityName.MADRID));
        cities.get(CityName.LONDON).addNeighbor(cities.get(CityName.PARIS));
        cities.get(CityName.LONDON).addNeighbor(cities.get(CityName.ESSEN));

        // paris
        cities.get(CityName.PARIS).addNeighbor(cities.get(CityName.LONDON));
        cities.get(CityName.PARIS).addNeighbor(cities.get(CityName.MADRID));
        cities.get(CityName.PARIS).addNeighbor(cities.get(CityName.ALGIERS));
        cities.get(CityName.PARIS).addNeighbor(cities.get(CityName.MILAN));
        cities.get(CityName.PARIS).addNeighbor(cities.get(CityName.ESSEN));

        // essen
        cities.get(CityName.ESSEN).addNeighbor(cities.get(CityName.LONDON));
        cities.get(CityName.ESSEN).addNeighbor(cities.get(CityName.PARIS));
        cities.get(CityName.ESSEN).addNeighbor(cities.get(CityName.MILAN));
        cities.get(CityName.ESSEN).addNeighbor(cities.get(CityName.ST_PETERSBURG));

        // milan
        cities.get(CityName.MILAN).addNeighbor(cities.get(CityName.ESSEN));
        cities.get(CityName.MILAN).addNeighbor(cities.get(CityName.PARIS));
        cities.get(CityName.MILAN).addNeighbor(cities.get(CityName.ISTANBUL));

        // st petersburg
        cities.get(CityName.ST_PETERSBURG).addNeighbor(cities.get(CityName.ESSEN));
        cities.get(CityName.ST_PETERSBURG).addNeighbor(cities.get(CityName.MOSCOW));
        cities.get(CityName.ST_PETERSBURG).addNeighbor(cities.get(CityName.ISTANBUL));


    }

    private void addYellowNeighbors() {

        // los angeles
        cities.get(CityName.LOS_ANGELES).addNeighbor(cities.get(CityName.SAN_FRANCISCO));
        cities.get(CityName.LOS_ANGELES).addNeighbor(cities.get(CityName.SYDNEY));
        cities.get(CityName.LOS_ANGELES).addNeighbor(cities.get(CityName.CHICAGO));
        cities.get(CityName.LOS_ANGELES).addNeighbor(cities.get(CityName.MEXICO_CITY));

        // mexico city
        cities.get(CityName.MEXICO_CITY).addNeighbor(cities.get(CityName.LOS_ANGELES));
        cities.get(CityName.MEXICO_CITY).addNeighbor(cities.get(CityName.CHICAGO));
        cities.get(CityName.MEXICO_CITY).addNeighbor(cities.get(CityName.MIAMI));
        cities.get(CityName.MEXICO_CITY).addNeighbor(cities.get(CityName.BOGOTA));
        cities.get(CityName.MEXICO_CITY).addNeighbor(cities.get(CityName.LIMA));

        // miami
        cities.get(CityName.MIAMI).addNeighbor(cities.get(CityName.WASHINGTON));
        cities.get(CityName.MIAMI).addNeighbor(cities.get(CityName.ATLANTA));
        cities.get(CityName.MIAMI).addNeighbor(cities.get(CityName.MEXICO_CITY));
        cities.get(CityName.MIAMI).addNeighbor(cities.get(CityName.BOGOTA));

        //bogota
        cities.get(CityName.BOGOTA).addNeighbor(cities.get(CityName.MEXICO_CITY));
        cities.get(CityName.BOGOTA).addNeighbor(cities.get(CityName.MIAMI));
        cities.get(CityName.BOGOTA).addNeighbor(cities.get(CityName.LIMA));
        cities.get(CityName.BOGOTA).addNeighbor(cities.get(CityName.BUENOS_AIRES));
        cities.get(CityName.BOGOTA).addNeighbor(cities.get(CityName.SAO_PAULO));

        // lima
        cities.get(CityName.LIMA).addNeighbor(cities.get(CityName.MEXICO_CITY));
        cities.get(CityName.LIMA).addNeighbor(cities.get(CityName.BOGOTA));
        cities.get(CityName.LIMA).addNeighbor(cities.get(CityName.SAN_FRANCISCO));

        // santiago
        cities.get(CityName.SANTIAGO).addNeighbor(cities.get(CityName.LIMA));

        // buenos aires
        cities.get(CityName.BUENOS_AIRES).addNeighbor(cities.get(CityName.BOGOTA));
        cities.get(CityName.BUENOS_AIRES).addNeighbor(cities.get(CityName.SAO_PAULO));

        // sao paulo
        cities.get(CityName.SAO_PAULO).addNeighbor(cities.get(CityName.BOGOTA));
        cities.get(CityName.SAO_PAULO).addNeighbor(cities.get(CityName.BUENOS_AIRES));
        cities.get(CityName.SAO_PAULO).addNeighbor(cities.get(CityName.MADRID));
        cities.get(CityName.SAO_PAULO).addNeighbor(cities.get(CityName.LAGOS));

        // lagos
        cities.get(CityName.LAGOS).addNeighbor(cities.get(CityName.SAO_PAULO));
        cities.get(CityName.LAGOS).addNeighbor(cities.get(CityName.KINSHASA));
        cities.get(CityName.LAGOS).addNeighbor(cities.get(CityName.KHARTOUM));

        // kinshasa
        cities.get(CityName.KINSHASA).addNeighbor(cities.get(CityName.LAGOS));
        cities.get(CityName.KINSHASA).addNeighbor(cities.get(CityName.KHARTOUM));
        cities.get(CityName.KINSHASA).addNeighbor(cities.get(CityName.JOHANNESBURG));

        // khartoum
        cities.get(CityName.KHARTOUM).addNeighbor(cities.get(CityName.LAGOS));
        cities.get(CityName.KHARTOUM).addNeighbor(cities.get(CityName.KINSHASA));
        cities.get(CityName.KHARTOUM).addNeighbor(cities.get(CityName.JOHANNESBURG));
        cities.get(CityName.KHARTOUM).addNeighbor(cities.get(CityName.CAIRO));

        // johannesburg
        cities.get(CityName.JOHANNESBURG).addNeighbor(cities.get(CityName.KINSHASA));
        cities.get(CityName.JOHANNESBURG).addNeighbor(cities.get(CityName.KHARTOUM));

    }

    private void addBlackNeighbors() {

        // algiers
        cities.get(CityName.ALGIERS).addNeighbor(cities.get(CityName.CAIRO));
        cities.get(CityName.ALGIERS).addNeighbor(cities.get(CityName.MADRID));
        cities.get(CityName.ALGIERS).addNeighbor(cities.get(CityName.PARIS));
        cities.get(CityName.ALGIERS).addNeighbor(cities.get(CityName.ISTANBUL));

        // cairo
        cities.get(CityName.CAIRO).addNeighbor(cities.get(CityName.ALGIERS));
        cities.get(CityName.CAIRO).addNeighbor(cities.get(CityName.ISTANBUL));
        cities.get(CityName.CAIRO).addNeighbor(cities.get(CityName.KHARTOUM));
        cities.get(CityName.CAIRO).addNeighbor(cities.get(CityName.RIYADH));
        cities.get(CityName.CAIRO).addNeighbor(cities.get(CityName.BAGHDAD));

        // istanbul
        cities.get(CityName.ISTANBUL).addNeighbor(cities.get(CityName.ALGIERS));
        cities.get(CityName.ISTANBUL).addNeighbor(cities.get(CityName.CAIRO));
        cities.get(CityName.ISTANBUL).addNeighbor(cities.get(CityName.BAGHDAD));
        cities.get(CityName.ISTANBUL).addNeighbor(cities.get(CityName.MILAN));
        cities.get(CityName.ISTANBUL).addNeighbor(cities.get(CityName.ST_PETERSBURG));
        cities.get(CityName.ISTANBUL).addNeighbor(cities.get(CityName.MOSCOW));

        // moscow
        cities.get(CityName.MOSCOW).addNeighbor(cities.get(CityName.ST_PETERSBURG));
        cities.get(CityName.MOSCOW).addNeighbor(cities.get(CityName.ISTANBUL));
        cities.get(CityName.MOSCOW).addNeighbor(cities.get(CityName.TEHRAN));

        // baghdad
        cities.get(CityName.BAGHDAD).addNeighbor(cities.get(CityName.ISTANBUL));
        cities.get(CityName.BAGHDAD).addNeighbor(cities.get(CityName.CAIRO));
        cities.get(CityName.BAGHDAD).addNeighbor(cities.get(CityName.RIYADH));
        cities.get(CityName.BAGHDAD).addNeighbor(cities.get(CityName.KARACHI));
        cities.get(CityName.BAGHDAD).addNeighbor(cities.get(CityName.TEHRAN));

        // riyadh
        cities.get(CityName.RIYADH).addNeighbor(cities.get(CityName.CAIRO));
        cities.get(CityName.RIYADH).addNeighbor(cities.get(CityName.BAGHDAD));
        cities.get(CityName.RIYADH).addNeighbor(cities.get(CityName.KARACHI));

        // tehran
        cities.get(CityName.TEHRAN).addNeighbor(cities.get(CityName.MOSCOW));
        cities.get(CityName.TEHRAN).addNeighbor(cities.get(CityName.BAGHDAD));
        cities.get(CityName.TEHRAN).addNeighbor(cities.get(CityName.KARACHI));
        cities.get(CityName.TEHRAN).addNeighbor(cities.get(CityName.DELHI));

        // karachi
        cities.get(CityName.KARACHI).addNeighbor(cities.get(CityName.RIYADH));
        cities.get(CityName.KARACHI).addNeighbor(cities.get(CityName.BAGHDAD));
        cities.get(CityName.KARACHI).addNeighbor(cities.get(CityName.TEHRAN));
        cities.get(CityName.KARACHI).addNeighbor(cities.get(CityName.DELHI));
        cities.get(CityName.KARACHI).addNeighbor(cities.get(CityName.MUMBAI));

        // delhi
        cities.get(CityName.DELHI).addNeighbor(cities.get(CityName.TEHRAN));
        cities.get(CityName.DELHI).addNeighbor(cities.get(CityName.KARACHI));
        cities.get(CityName.DELHI).addNeighbor(cities.get(CityName.MUMBAI));
        cities.get(CityName.DELHI).addNeighbor(cities.get(CityName.CHENNAI));
        cities.get(CityName.DELHI).addNeighbor(cities.get(CityName.KOLKATA));

        // mumbai
        cities.get(CityName.MUMBAI).addNeighbor(cities.get(CityName.KARACHI));
        cities.get(CityName.MUMBAI).addNeighbor(cities.get(CityName.DELHI));
        cities.get(CityName.MUMBAI).addNeighbor(cities.get(CityName.CHENNAI));

        // chennai
        cities.get(CityName.CHENNAI).addNeighbor(cities.get(CityName.MUMBAI));
        cities.get(CityName.CHENNAI).addNeighbor(cities.get(CityName.DELHI));
        cities.get(CityName.CHENNAI).addNeighbor(cities.get(CityName.KOLKATA));
        cities.get(CityName.CHENNAI).addNeighbor(cities.get(CityName.BANGKOK));
        cities.get(CityName.CHENNAI).addNeighbor(cities.get(CityName.JAKARTA));

        // kolkata
        cities.get(CityName.KOLKATA).addNeighbor(cities.get(CityName.DELHI));
        cities.get(CityName.KOLKATA).addNeighbor(cities.get(CityName.CHENNAI));
        cities.get(CityName.KOLKATA).addNeighbor(cities.get(CityName.BANGKOK));
        cities.get(CityName.KOLKATA).addNeighbor(cities.get(CityName.HONG_KONG));

    }

    private void addRedNeighbors() {

        // bangkok
        cities.get(CityName.BANGKOK).addNeighbor(cities.get(CityName.KOLKATA));
        cities.get(CityName.BANGKOK).addNeighbor(cities.get(CityName.CHENNAI));
        cities.get(CityName.BANGKOK).addNeighbor(cities.get(CityName.JAKARTA));
        cities.get(CityName.BANGKOK).addNeighbor(cities.get(CityName.HO_CHI_MINH_CITY));
        cities.get(CityName.BANGKOK).addNeighbor(cities.get(CityName.HONG_KONG));

        // jakarta
        cities.get(CityName.JAKARTA).addNeighbor(cities.get(CityName.CHENNAI));
        cities.get(CityName.JAKARTA).addNeighbor(cities.get(CityName.BANGKOK));
        cities.get(CityName.JAKARTA).addNeighbor(cities.get(CityName.HO_CHI_MINH_CITY));
        cities.get(CityName.JAKARTA).addNeighbor(cities.get(CityName.SYDNEY));

        // ho chi minh city
        cities.get(CityName.HO_CHI_MINH_CITY).addNeighbor(cities.get(CityName.JAKARTA));
        cities.get(CityName.HO_CHI_MINH_CITY).addNeighbor(cities.get(CityName.BANGKOK));
        cities.get(CityName.HO_CHI_MINH_CITY).addNeighbor(cities.get(CityName.HONG_KONG));
        cities.get(CityName.HO_CHI_MINH_CITY).addNeighbor(cities.get(CityName.MANILA));

        // hong kong
        cities.get(CityName.HONG_KONG).addNeighbor(cities.get(CityName.KOLKATA));
        cities.get(CityName.HONG_KONG).addNeighbor(cities.get(CityName.BANGKOK));
        cities.get(CityName.HONG_KONG).addNeighbor(cities.get(CityName.HO_CHI_MINH_CITY));
        cities.get(CityName.HONG_KONG).addNeighbor(cities.get(CityName.MANILA));
        cities.get(CityName.HONG_KONG).addNeighbor(cities.get(CityName.TAIPEI));
        cities.get(CityName.HONG_KONG).addNeighbor(cities.get(CityName.SHANGHAI));

        // beijing
        cities.get(CityName.BEIJING).addNeighbor(cities.get(CityName.SEOUL));
        cities.get(CityName.BEIJING).addNeighbor(cities.get(CityName.SHANGHAI));

        // seoul
        cities.get(CityName.SEOUL).addNeighbor(cities.get(CityName.BEIJING));
        cities.get(CityName.SEOUL).addNeighbor(cities.get(CityName.SHANGHAI));
        cities.get(CityName.SEOUL).addNeighbor(cities.get(CityName.TOKYO));

        // tokyo
        cities.get(CityName.TOKYO).addNeighbor(cities.get(CityName.SEOUL));
        cities.get(CityName.TOKYO).addNeighbor(cities.get(CityName.SHANGHAI));
        cities.get(CityName.TOKYO).addNeighbor(cities.get(CityName.SAN_FRANCISCO));
        cities.get(CityName.TOKYO).addNeighbor(cities.get(CityName.OSAKA));

        // shanghai
        cities.get(CityName.SHANGHAI).addNeighbor(cities.get(CityName.SEOUL));
        cities.get(CityName.SHANGHAI).addNeighbor(cities.get(CityName.BEIJING));
        cities.get(CityName.SHANGHAI).addNeighbor(cities.get(CityName.TOKYO));
        cities.get(CityName.SHANGHAI).addNeighbor(cities.get(CityName.TAIPEI));
        cities.get(CityName.SHANGHAI).addNeighbor(cities.get(CityName.HONG_KONG));

        // osaka
        cities.get(CityName.OSAKA).addNeighbor(cities.get(CityName.TOKYO));
        cities.get(CityName.OSAKA).addNeighbor(cities.get(CityName.TAIPEI));

        // taipei
        cities.get(CityName.TAIPEI).addNeighbor(cities.get(CityName.OSAKA));
        cities.get(CityName.TAIPEI).addNeighbor(cities.get(CityName.HONG_KONG));
        cities.get(CityName.TAIPEI).addNeighbor(cities.get(CityName.MANILA));

        // manila
        cities.get(CityName.MANILA).addNeighbor(cities.get(CityName.TAIPEI));
        cities.get(CityName.MANILA).addNeighbor(cities.get(CityName.HONG_KONG));
        cities.get(CityName.MANILA).addNeighbor(cities.get(CityName.HO_CHI_MINH_CITY));
        cities.get(CityName.MANILA).addNeighbor(cities.get(CityName.SYDNEY));
        cities.get(CityName.MANILA).addNeighbor(cities.get(CityName.SAN_FRANCISCO));

        // sydney
        cities.get(CityName.SYDNEY).addNeighbor(cities.get(CityName.JAKARTA));
        cities.get(CityName.SYDNEY).addNeighbor(cities.get(CityName.MANILA));
        cities.get(CityName.SYDNEY).addNeighbor(cities.get(CityName.LOS_ANGELES));

    }

}
