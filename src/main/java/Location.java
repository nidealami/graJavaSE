import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location {
    private String longDescription;
    private String shortDescription;
    private Map<Direction, Location> exit;
    private List<NPC> npcs;


    public Location(String shortDescription, String longDescription) {
        this.longDescription = longDescription;
        this.shortDescription = shortDescription;
        this.exit = new HashMap<>();
        this.npcs = new ArrayList<>();
    }

    public String getDescription() {
        return this.shortDescription + "\n" + this.longDescription + "\n " + "widoczne wyjścia: " + getExitString() + "\n ";
    }

    public void addExit(Direction direction, Location location) {
        this.exit.put(direction, location);
    }

    public Location getNextLocation(Direction direction) {
        boolean exits = this.exit.containsKey(direction);
        if (exits) {
            return this.exit.get(direction);
        } else {
            return null;
        }
    }

    private String getExitString() {
        String exitString = "";
        for (Direction direction : exit.keySet()) {
            exitString += direction.getDirectionDescription() + " ";
        }
        return exitString;
    }

    public void addNpcs(NPC npc) {
        this.npcs.add(npc);
    }

    public boolean isThereNPC(String npcName) {
        for(NPC npc:this.npcs){
            if (npc.getName().equalsIgnoreCase(npcName)){
                return true;
            }
        }
        return false;
    }


    public NPC getNPC(String npcName) {
        for (NPC npc : this.npcs) {
            if (npc.getName().equalsIgnoreCase(npcName)) {
                return npc;
            }
        }
        return null;
    }



}
