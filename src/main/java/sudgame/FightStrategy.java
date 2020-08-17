package sudgame;

import domain.NPC;
import domain.Player;

public interface FightStrategy {

    public void fight(Player player, NPC targetNPC);
}
