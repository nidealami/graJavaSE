import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hejka");

        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        String PlayerName = scanner.nextLine();
        System.out.println("Hi " + PlayerName);

        Player player = new Player(PlayerName);
        Location startLocation = new Location("Small Room", "You are in small room, darm one. Single bed only and books on the floor...");
        Location secondLocation = new Location("Dark corridor", "...");

        startLocation.addExit(Direction.N, secondLocation);
        secondLocation.addExit(Direction.S, startLocation);

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
        switch (command) {
            case "n":
            case "polnoc":
                move(Direction.N, player);
                break;
            case "s":
            case "poludnie":
                move(Direction.S, player);
                break;
            case "w":
            case "zachod":
                move(Direction.W, player);
                break;
            case "e":
            case "wschod":
                move(Direction.E, player);
                break;
            default:
                System.out.println("O co ci chodzi? Wybierz: n lub s lub w lub e");
        }
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

