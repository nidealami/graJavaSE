package services;

import domain.Location;
import domain.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LookCommandTest {

    private Location mainLocation;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
    }

    @Test
    public void lookTest() {
        Player p = new Player("TestPlayer");
        p.setCurrentLocation(mainLocation);
        LookCommand look = new LookCommand(p);
        String result = look.execute();
        assertEquals(mainLocation.getDescription(), result);
    }
}
