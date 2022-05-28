/* Copyright 2021 Sabre Holdings */
package footbal;

/*
* Create an implementation of FootballStats interface
* find the average distance covered by all forwards
*/

import footbal.player.PitchPosition;
import footbal.player.Player;

import java.util.List;

public class FootballStatsDraft implements FootballStats{

    @Override
    public Double calculateDistanceCovered(List<Player> players) {
        if(players == null || players.contains(null)){
            throw new NullPointerException("The Input List Can Not Contain Nulls Or Be Null.");
        }
        return (double)players.stream().filter(p -> p.getPitchPosition().equals(PitchPosition.FORWARD)).mapToInt(Player::getDistanceCovered).sum();
    }
}
