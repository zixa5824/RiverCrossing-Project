package LevelOne;
import RiverCrossing.Crosser;
import RiverCrossing.ICrosser;

import java.awt.image.BufferedImage;

public class Plant extends Crosser implements ICrosser {

    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int getEatingRank() {
        return 1;
    }

    /*  @Override
    public BufferedImage[] getImages() {
        // TODO Auto-generated method stub
        return null;
    }
    */
    @Override
    public ICrosser makeCopy() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLabelToBeShown(String label) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getLabelToBeShown() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BufferedImage[] getImages() {
        return new BufferedImage[0];
    }
}
