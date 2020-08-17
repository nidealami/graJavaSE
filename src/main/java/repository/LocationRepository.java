package repository;

import domain.Direction;
import domain.Location;
import domain.NPC;

public class LocationRepository {
    Location startLocation;
    Location secondLocation;

    public LocationRepository() {

        startLocation = new Location("Small Room", "You are in small room, darm one. Single bed only and books on the floor...");
        secondLocation = new Location("Dark corridor", "...");

        startLocation.addExit(Direction.N, secondLocation);
        secondLocation.addExit(Direction.S, startLocation);

        NPC ork = new NPC("Ork", 50, 5,10);
        startLocation.addNpcs(ork);
    }

    public Location getStartLocation() {
        return this.startLocation;
    }
}
