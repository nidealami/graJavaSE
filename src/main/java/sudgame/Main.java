package sudgame;

import repository.LocationRepository;
import domain.Direction;
import domain.NPC;
import domain.Player;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LocationRepository locationRepository=new LocationRepository();

        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        String playerName = scanner.nextLine();

        Player player = new Player(playerName, 100, 10);

        player.setCurrentLocation(locationRepository.getStartLocation());

        System.out.println(player.getCurrentLocationDescription());

        String command = "";
        while (!command.equals("quit")) {
            command = readPlayerInput(scanner);

            actOnCommand(command, player);
        }
        System.out.println("Goodbye!");
    }

    private static String readPlayerInput(Scanner scanner) {
        System.out.println(">");

        String command = scanner.nextLine();
        return command;
    }

    private static void actOnCommand(String command, Player player) {
        command = command.toLowerCase();

        String[] splitted = command.split(" ");

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

    private static void attack(String target, Player player) {
        NPC targetNPC = player.getNearbyNPC(target);
        if (target != null) {
            beginCombat(player, targetNPC);
        } else {
            System.out.println("There is no one like that around");
        }
    }

    private static void beginCombat(Player player, NPC targetNPC) {
        FightThread ft = new FightThread(player, targetNPC);
        Thread t = new Thread(ft);

        t.start();
    }

    private static void move(Direction direction, Player player) {
        boolean hasMoved = player.move(direction);
        if (hasMoved) {
            System.out.println(player.getCurrentLocationDescription());
        } else {
            System.out.println("nie możesz isc tedy");
        }
    }
}

