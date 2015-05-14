package strategy.framework.player.other;

import model.card.type.PlayerCard;
import model.player.hand.Hand;

/**
 * Created by brandt on 5/14/15.
 */
public interface IDiscardStrategy {

    public boolean mustDiscard(Hand hand);
    public boolean discardCard(Hand hand, PlayerCard card);

}
