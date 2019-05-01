package LevelOne;
import RiverCrossing.Crosser;
import RiverCrossing.ICrosser;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Farmer extends Crosser implements ICrosser {

    private String label;

    @Override
    public boolean canSail() {
        return true;
    }

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public int getEatingRank() {
        return 10;
    }

    @Override
    public BufferedImage[] getImages() {

        BufferedImage[] bufferedImage = new BufferedImage[2];
        File file1 = new File("leftFarmer.png");
        try {
            bufferedImage[0] = ImageIO.read(file1);
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        File file2 = new File("rightFarmer.png");
        try {
            bufferedImage[1] = ImageIO.read(file2);
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        return bufferedImage;
    }

    @Override
    public ICrosser makeCopy() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLabelToBeShown(String label) {
        this.label = label;
    }

    @Override
    public String getLabelToBeShown() {
        return label;
    }


}
