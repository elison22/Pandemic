package model;

import java.util.ArrayList;

import model.player.Player;
import strategy.framework.factory.IRoleStrategyFactory;

/**
 * Created by brandt on 5/21/15.
 */
public class RoleManager {

    ArrayList<Player> players = new ArrayList<Player>();
    ArrayList<IRoleStrategyFactory> factories = new ArrayList<IRoleStrategyFactory>();

    public int getPlayerCount() {
        return players.size();
    }

    public boolean canAddPlayer() {
        int count = getPlayerCount();
        if(count >= 2 && count <= 4) return true;
        else return false;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }



}
