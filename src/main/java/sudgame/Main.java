package sudgame;

import sudgame.repository.LocationRepository;
import sudgame.domain.Player;
import sudgame.services.CommandParser;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LocationRepository locationRepository = new LocationRepository();
        CommandParser parser = new CommandParser();

        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        String playerName = scanner.nextLine();

        Player player = new Player(playerName, 100, 10, 25);

        player.setCurrentLocation(locationRepository.getStartLocation());

        System.out.println(player.getCurrentLocationDescription());

        String command = "";
        while (!command.equals("quit")) {
            command = readPlayerInput(scanner);
            parser.actOnCommand(command, player);
        }
        System.out.println("Goodbye!");
    }

    private static String readPlayerInput(Scanner scanner) {
        System.out.println(">");

        String command = scanner.nextLine();
        return command;
    }

}

