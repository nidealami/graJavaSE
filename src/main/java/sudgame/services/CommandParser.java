package sudgame.services;

import sudgame.domain.Direction;
import sudgame.domain.NPC;
import sudgame.domain.Player;
import sudgame.AgilityFightStrategy;

import sudgame.FightStrategy;
import sudgame.FightThread;

public class CommandParser {
    public void actOnCommand(String playerCommand, Player player) {
        playerCommand = playerCommand.toLowerCase();

        String[] splitted = playerCommand.split(" ");
        Command command = null;

        switch (splitted[0]) {
            case "n":
            case "north":
                move(Direction.N, player);
                break;
            case "s":
            case "south":
                move(Direction.S, player);
                break;
            case "w":
            case "west":
                move(Direction.W, player);
                break;
            case "e":
            case "east":
                move(Direction.E, player);
                break;
            case "kill":
                attack(splitted[1], player);
                break;
            default:
                System.out.println("O co ci chodzi? Wybierz: n lub s lub w lub e");
        }
    }

    public void attack(String target, Player player) {
        NPC targetNPC = player.getNearbyNPC(target);
        if (target != null) {
            beginCombat(player, targetNPC);
        } else {
            System.out.println("There is no one like that around");
        }
    }

    private void beginCombat(Player player, NPC targetNPC) {
        FightStrategy fs = new AgilityFightStrategy();

        FightThread ft = new FightThread(player, targetNPC, fs);
        Thread t = new Thread(ft);

        t.start();
    }

    public void move(Direction direction, Player player) {
        boolean hasMoved = player.move(direction);
        if (hasMoved) {
            System.out.println(player.getCurrentLocationDescription());
        } else {
            System.out.println("nie możesz isc tedy");
        }
    }
}

