package sudgame;

import sudgame.domain.NPC;
import sudgame.domain.Player;

public interface FightStrategy {

    public void fight(Player player, NPC targetNPC);
}
