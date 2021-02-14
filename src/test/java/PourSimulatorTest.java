import org.junit.Test;

import static org.junit.Assert.*;

public class PourSimulatorTest {

    PourSimulator simulator = new PourSimulator();

    @Test
    public void testCorrectVolumeInFirstGlass() {
        simulator.pour(0, 0, 0.5);
        assertEquals(0.5, simulator.glassMap.get(0, 0).getCurrentVolume(), 0);
    }

    @Test
    public void testOverflowVolumeInFirstGlass() {
        simulator.pour(0, 0, 2);
        assertEquals(1, simulator.glassMap.get(0, 0).getCurrentVolume(), 0);
    }
}