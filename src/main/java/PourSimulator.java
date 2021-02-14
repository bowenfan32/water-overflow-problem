import com.google.common.collect.HashBasedTable;

public class PourSimulator {

    HashBasedTable<Integer, Integer, Glass> glassMap = HashBasedTable.create();
    public static final double MAX_CAPACITY = 1;

    public void pour(int i, int j, double volume) {
        Glass firstGlass = new Glass();
        if (volume < MAX_CAPACITY) {
            firstGlass.setCurrentVolume(volume);
        } else {
            firstGlass.setCurrentVolume(MAX_CAPACITY);
        }
        glassMap.put(i, j, firstGlass);

    }
}
