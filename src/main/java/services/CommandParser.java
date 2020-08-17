package services;

import domain.Direction;
import domain.Player;


public class CommandParser {

    public void actOnCommand(String playerCommand, Player player) {
        playerCommand = playerCommand.toLowerCase();

        String[] splitted = playerCommand.split(" ");
        Command command = null;

        switch (splitted[0]) {
            case "n":
            case "north":
                command = new MoveCommand(Direction.N, player);
                break;
            case "s":
            case "south":
                command = new MoveCommand(Direction.S, player);
                break;

            case "e":
            case "east":
                command = new MoveCommand(Direction.E, player);
                break;
            case "w":
            case "west":
                command = new MoveCommand(Direction.W, player);
                break;
            case "kill":
                command = new KillCommand(splitted[1], player);
                break;
            case "look":
                command = new LookCommand(player);
                break;
            default:
                System.out.println("O co ci chodzi? Wybierz: n lub s lub w lub e");
        }
        if (command != null) {
            System.out.println(command.execute());
        }
    }

}

