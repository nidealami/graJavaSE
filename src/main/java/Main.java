import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hejka");

        String PlayerName = askPlayerAboutName();

        Player player = new Player("Gracz Ania");
        Location startLoc = new Location("Short description", "Long description");

        player.setCurrentLocation(startLoc);

        System.out.println(player.getCurrentLocationDescription());
    }

    private static String askPlayerAboutName() {
        System.out.println("What's your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        scanner.close();

        System.out.println("Hi " + name);
        return name;
    }

    ;
}

