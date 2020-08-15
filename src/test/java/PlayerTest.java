import domain.Direction;
import domain.Location;
import domain.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
    Location mainLocation;
    Location northLocation;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
        northLocation = new Location("Second", "Long");
        mainLocation.addExit(Direction.N, northLocation);
    }

    @Test
    public void testPlayerMove() {
        Player player = new Player("Ania");
        player.setCurrentLocation(mainLocation);
        player.move(Direction.N);
        Assert.assertEquals("The same location", northLocation, player.getCurrentLocation());
    }
}


