package RiverCrossing.LevelTwo;

public class Boat {


    //singleton implementation
    private static Boat boat;
    public static Boat getInstance() {
        if (boat == null)
            boat = new Boat();
        return boat;
    }

    private Boat() {

    }


    //private int boatRiders = 0;

    private boolean side = true;

    private final double maxWeight = 100;

    public double getmaxWeight() {return maxWeight;}

    public boolean getSide() {return side;}

    public void changeSide() {
        if (side) side = false;
        else side = true;
        System.out.println("boat class boolean side variable changed to: "+side);
    }


}
