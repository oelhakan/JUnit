/* Copyright 2021 Sabre Holdings */
package footbal;

import footbal.player.Player;

import java.util.List;

public interface FootballStats
{
   Double calculateDistanceCovered(List<Player> players);
}
