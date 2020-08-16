package domain;

import org.junit.Before;
import sudgame.domain.Direction;
import sudgame.domain.Location;


public class PlayerTest {
    Location mainLocation;
    Location northLocation;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
        northLocation = new Location("Second", "Long");
        mainLocation.addExit(Direction.N, northLocation);
    }

}


