package model;

/**
 * Created by brandt on 5/30/15.
 */
public class GameLostException extends Exception {

    public GameLostException() {
        return;
    }

    public GameLostException(String message) {
        super(message);
    }

    public GameLostException(Throwable cause) {
        super(cause);
    }

    public GameLostException(String message, Throwable cause) {
        super(message, cause);
    }

}
