import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Three args required");
        }
        int i = Integer.parseInt(args[0]);
        int j = Integer.parseInt(args[1]);
        double volume = Double.parseDouble(args[2]);

        PourSimulator simulator = new PourSimulator();
        simulator.pour(0, 0, volume);

        Glass glass = simulator.glassMap.get(i, j);
        double glassVolume;
        if (glass == null) {
            glassVolume = 0;
        } else {
            glassVolume = glass.getCurrentVolume();
        }
        System.out.println("Glass " + i + "," + j + " has a volume of "
                + glassVolume);
    }
}
