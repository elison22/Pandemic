package model;

import model.board.Board;
import model.card.deck.InfectionDeck;
import model.card.deck.PlayerDeck;
import model.card.deck.RemovedDeck;

/**
 * Created by brandt on 5/13/15.
 */
public class Game {

    private Board board;
    private PlayerDeck playerDraw;
    private InfectionDeck infectDraw;
    private RemovedDeck removedCards;
    private int currentPlayer;  // 0-3;
    private int playerCount;    // 2-4;
    private int redState;       // 0 = not cured, 1 = cured, 2 = eradicated
    private int blueState;
    private int blackState;
    private int yellowState;

    public Game() {
        board = new Board();
        playerDraw = new PlayerDeck();
        infectDraw = new InfectionDeck();
        removedCards = new RemovedDeck();
        redState = 0;
        blueState = 0;
        blackState = 0;
        yellowState = 0;
    }

    private void begin() {
    }



}
