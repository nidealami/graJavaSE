import org.junit.Assert;
import org.junit.Test;

public class LocationTest {
    @Test
    public void testGetDescription() {
        Location loc = new Location("Short", "Long");
        String description = loc.getDescription();
        String validDescription = "Short\nLong\nVisible Exit";
        Assert.assertEquals("Compare description", validDescription, description);

    }
}
