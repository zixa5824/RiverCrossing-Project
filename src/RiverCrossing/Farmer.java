package RiverCrossing;
//import java.awt.image.BufferedImage;

public class Farmer extends Crosser implements ICrosser{

    @Override
    public boolean canSail() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int getEatingRank() {
        return 9;
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

}
