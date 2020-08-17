package services;

import domain.Player;

public class LookCommand implements Command {
    private Player player;

    public LookCommand(Player p) {
        this.player = p;
    }

    @Override
    public String execute() {

        return player.getCurrentLocationDescription();

    }
}
