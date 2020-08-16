package services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import sudgame.domain.Location;
import sudgame.domain.NPC;
import sudgame.domain.Player;
import sudgame.services.KillCommand;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

public class KillCommandTest {
    private Location mainLocation;
    NPC ork;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
        ork = new NPC("ork");
        mainLocation.addNpc(ork);
    }

    @Test
    public void beginCombatIfTargetIsThere() {
        Player testPlayer = new Player("TestPlayer");
        testPlayer.setCurrentLocation(mainLocation);
        KillCommand kill = new KillCommand("ork",testPlayer);
        KillCommand killSpy = Mockito.spy(kill);
        killSpy.execute();
        Mockito.verify(killSpy,times(1)).beginCombat(testPlayer, ork);
    }

    @Test
    public void returnTargetNotThereInfoIfTargetIsNoOnLocation() {
        Player testPlayer = new Player("TestPlayer");
        testPlayer.setCurrentLocation(mainLocation);
        KillCommand kill = new KillCommand("goblin", testPlayer);
        String result = kill.execute();
        assertEquals("There's no one like that around.  ",result);
    }
}
