package sudgame.services;

import sudgame.domain.NPC;
import sudgame.domain.Player;

public class KillCommand implements Command{


    public KillCommand(String ork, Player testPlayer) {
    }

    public String execute() {
        return null;
    }

    public void beginCombat(Player testPlayer, NPC ork) {
    }
}
