package model.card.type;

import enums.EventCardType;

/**
 * Created by brandt on 5/13/15.
 */
public class EventCard extends GameCard{

    EventCardType eventType;

    public EventCardType getEventType() {
        return eventType;
    }
    public void setEventType(EventCardType eventType) {
        this.eventType = eventType;
    }

}
