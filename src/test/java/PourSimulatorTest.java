import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PourSimulatorTest {

    PourSimulator simulator = new PourSimulator();

    @Test
    public void testCorrectVolumeInFirstGlass() {
        simulator.pour(0, 0, 0.5);
        assertEquals(0.5, simulator.glassMap.get(0, 0).getCurrentVolume(), 0);
    }

    @Test
    public void testSecondLayerGlassDoesNotContainWater() {
        simulator.pour(0, 0, 1);
        assertFalse(simulator.glassMap.contains(1, 0));
        assertFalse(simulator.glassMap.contains(1, 1));
    }

    @Test
    public void testOverflowVolumeInFirstGlass() {
        simulator.pour(0, 0, 2);
        assertEquals(1, simulator.glassMap.get(0, 0).getCurrentVolume(), 0);
        assertTrue(simulator.glassMap.contains(1, 0));
        assertTrue(simulator.glassMap.contains(1, 0));
    }

    @Test
    public void testSecondLayerGlassesHasCorrectVolume() {
        simulator.pour(0, 0, 2);
        assertEquals(0.5, simulator.glassMap.get(1, 0).getCurrentVolume(), 0);
        assertEquals(0.5, simulator.glassMap.get(1, 1).getCurrentVolume(), 0);
    }

    @Test
    public void testThirdLayerGlassesHasCorrectVolume() {
        simulator.pour(0, 0, 4);
        assertEquals(0.25, simulator.glassMap.get(2, 0).getCurrentVolume(), 0);
        assertEquals(0.5, simulator.glassMap.get(2, 1).getCurrentVolume(), 0);
        assertEquals(0.25, simulator.glassMap.get(2, 2).getCurrentVolume(), 0);
    }

    @Test
    public void testTotalVolumeInGlassesAreSameAsVolumePoured() {
        simulator.pour(0, 0, 20);

        ArrayList<Glass> glasses = new ArrayList<>(simulator.glassMap.values());
        double total = 0;
        for (Glass glass : glasses) {
            total += glass.getCurrentVolume();
        }

        assertEquals(20, total, 0);
    }
}