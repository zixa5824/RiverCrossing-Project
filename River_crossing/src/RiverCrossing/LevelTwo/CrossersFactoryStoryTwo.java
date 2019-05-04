package RiverCrossing.LevelTwo;

import RiverCrossing.ICrosser;

public class CrossersFactoryStoryTwo {
    public ICrosser getCrosser(String type, double weight) {

        if (type.equalsIgnoreCase("farmer")) return new Farmer(weight);
        else if (type.equalsIgnoreCase("animal")) return new Animal(weight);

        return null;
    }
}





















