import com.google.common.collect.HashBasedTable;

public class PourSimulator {

    HashBasedTable<Integer, Integer, Glass> glassMap = HashBasedTable.create();
    public static final double MAX_CAPACITY = 1;

    public void pour(int i, int j, double volume) {
        double remainder = 0;
        Glass firstGlass = new Glass();
        if (volume > MAX_CAPACITY) {
            firstGlass.setCurrentVolume(MAX_CAPACITY);
            remainder = volume - MAX_CAPACITY;
        } else {
            firstGlass.setCurrentVolume(volume);
        }
        glassMap.put(i, j, firstGlass);

        if (remainder > 0) {
            pourToSide(i + 1, j, remainder / 2);
            pourToSide(i + 1, j + 1, remainder / 2);
        }
    }

    public void pourToSide(int i, int j, double volume) {
        double remainder = 0;
        Glass glass = new Glass();

        // if glass never visited
        if (!glassMap.contains(i, j)) {
            // if incoming flow is greater than capacity, get remainder
            if (volume > MAX_CAPACITY) {
                glass.setCurrentVolume(MAX_CAPACITY);
                remainder = volume - MAX_CAPACITY;
            } else {
                glass.setCurrentVolume(volume);
            }
        } else {  // if glass has been visited before
            // get current volume + incoming volume and calculate remainder
            double updatedVolume = volume + glassMap.get(i, j).getCurrentVolume();
            if (updatedVolume > MAX_CAPACITY) {
                glass.setCurrentVolume(MAX_CAPACITY);
                remainder = updatedVolume - MAX_CAPACITY;
            } else {
                glass.setCurrentVolume(updatedVolume);
            }
        }
        glassMap.put(i, j, glass);

        if (remainder > 0) {
            pourToSide(i + 1, j, remainder / 2);
            pourToSide(i + 1, j + 1, remainder / 2);
        }
    }
}
