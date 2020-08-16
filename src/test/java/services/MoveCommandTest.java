package services;

import sudgame.domain.Direction;
import sudgame.domain.Location;
import sudgame.domain.NPC;
import sudgame.domain.Player;
import org.junit.Before;
import org.junit.Test;
import sudgame.services.MoveCommand;

import static org.junit.Assert.assertEquals;


public class MoveCommandTest {
    Location mainLocation;
    Location northLocation;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
        northLocation = new Location("Second", "Long");
        mainLocation.addExit(Direction.N, northLocation);
        NPC ork = new NPC("ork");
        mainLocation.addNpcs(ork);
    }

    @Test
    public void moveIfProperDirectionIsSend() {
        Player p = new Player("TestPlayer");
        p.setCurrentLocation(mainLocation);
        MoveCommand move = new MoveCommand(Direction.N,p);
        String result = move.execute();
        assertEquals(northLocation.getDescription(),result);

    }
    @Test
    public void returnInfoIfThereIsNoLocationInGivenDirection() {
        Player p = new Player("TestPlayer");
        p.setCurrentLocation(mainLocation);
        MoveCommand move = new MoveCommand(Direction.S, p);
        String result = move.execute();
        assertEquals("You can't go that way.", result);
    }

}
