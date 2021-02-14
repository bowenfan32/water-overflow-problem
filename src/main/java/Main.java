public class Main {

    public static void main(String[] args) {
        PourSimulator program = new PourSimulator();
        program.pour(0, 0, 1.0);
        System.out.println(program.glassMap.get(0,0).getCurrentVolume());
    }
}
