import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        PourSimulator simulator = new PourSimulator();
        simulator.pour(0, 0, 10.0);
        System.out.println(simulator.glassMap.get(2,0).getCurrentVolume());


        ArrayList<Glass> arr = new ArrayList<>(simulator.glassMap.values());
        double total = 0;
        for (Glass glass : arr) {
            total += glass.getCurrentVolume();
        }
        System.out.println(total);
        System.out.println(simulator.glassMap.contains(20, 20));
    }
}
