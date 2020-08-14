import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hejka");

        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        String playerName = scanner.nextLine();
        System.out.println("Hi " + playerName);

        Player player = new Player(playerName, 100, 10);

        Location startLocation = new Location("Small Room", "You are in small room, darm one. Single bed only and books on the floor...");
        Location secondLocation = new Location("Dark corridor", "...");

        startLocation.addExit(Direction.N, secondLocation);
        secondLocation.addExit(Direction.S, startLocation);

        NPC ork = new NPC("Ork", 50, 5);

        startLocation.addNpcs(ork);

        player.setCurrentLocation(startLocation);

        System.out.println(player.getCurrentLocationDescription());

        String command = "";
        while (!command.equals("zakoncz")) {
            command = readPlayerInput(scanner);

            actOnCommand(command, player);
        }
        System.out.println("Do zobaczenia!");
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

