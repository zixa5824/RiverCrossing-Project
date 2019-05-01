package LevelOne;

import RiverCrossing.ICrosser;

import java.util.ArrayList;
import java.util.List;

public class Boat {

    List<ICrosser> boatRiders = new ArrayList<>();
    public void addBoatRiders(ICrosser iCrosser)
    {
        boatRiders.add(iCrosser);
    }

    public ICrosser removeBoatRiders(ICrosser iCrosser)
    {
        boatRiders.remove(iCrosser);
        return iCrosser;
    }

    public boolean checkRiderOnBoat(ICrosser iCrosser)
    {
        if(boatRiders.contains(iCrosser))
            return true;
        return false;
    }

    public boolean isBoatFull()
    {
        if(boatRiders.size() == 2)
            return true;
        return false;
    }

    public void removeAllBoatRiders()
    {
       boatRiders.clear();
    }


    public List<ICrosser> getBoatRiders() {
        return boatRiders;
    }
}
