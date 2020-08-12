import java.util.HashMap;
import java.util.Map;

public class Location {
    private String longDescription;
    private String shortDescription;
    private Map<Direction, Location> exit;

    public Location(String shortDescription, String longDescription) {
        this.longDescription = longDescription;
        this.shortDescription = shortDescription;
        this.exit = new HashMap<Direction, Location>();
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return this.shortDescription + "\n" + this.longDescription + "\n " + "widoczne wyjścia: " + getExitString();
    }

    private String getExitString() {
        String exitString = "";
        for (Direction direction : exit.keySet()) {
            exitString += direction.getDirectionDescription() + " ";
        }
        return exitString;
    }

    public void addExit(Direction direction, Location location) {
        this.exit.put(direction, location);
    }

    public Location getNextLocation(Direction direction) {
        boolean exit = this.exit.containsKey(direction);
        if (exit) {
            return this.exit.get(direction);
        } else {
            return null;
        }
    }
}
