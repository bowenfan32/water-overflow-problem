import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class PourSimulatorTest {

    PourSimulator simulator = new PourSimulator();

    @Test
    public void testCorrectVolumeInFirstGlass() {
        simulator.pour(0, 0, 250);
        assertEquals(250, simulator.glassMap.get(0, 0).getCurrentVolume(), 0);
    }

    @Test
    public void testSecondLayerGlassDoesNotContainWater() {
        simulator.pour(0, 0, 250);
        assertFalse(simulator.glassMap.contains(1, 0));
        assertFalse(simulator.glassMap.contains(1, 1));
    }

    @Test
    public void testOverflowVolumeInFirstGlass() {
        simulator.pour(0, 0, 500);
        assertEquals(250, simulator.glassMap.get(0, 0).getCurrentVolume(), 0);
        assertTrue(simulator.glassMap.contains(1, 0));
        assertTrue(simulator.glassMap.contains(1, 0));
    }

    @Test
    public void testSecondLayerGlassesHasCorrectVolume() {
        simulator.pour(0, 0, 500);
        assertEquals(125, simulator.glassMap.get(1, 0).getCurrentVolume(), 0);
        assertEquals(125, simulator.glassMap.get(1, 1).getCurrentVolume(), 0);
    }

    @Test
    public void testThirdLayerGlassesHasCorrectVolume() {
        simulator.pour(0, 0, 1000);
        assertEquals(62.5, simulator.glassMap.get(2, 0).getCurrentVolume(), 0);
        assertEquals(125, simulator.glassMap.get(2, 1).getCurrentVolume(), 0);
        assertEquals(62.5, simulator.glassMap.get(2, 2).getCurrentVolume(), 0);
    }

    @Test
    public void testTotalVolumeInGlassesAreSameAsVolumePoured() {
        simulator.pour(0, 0, 10000);

        ArrayList<Glass> glasses = new ArrayList<>(simulator.glassMap.values());
        double total = 0;
        for (Glass glass : glasses) {
            total += glass.getCurrentVolume();
        }

        assertEquals(10000, total, 0);
    }
}