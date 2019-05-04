package RiverCrossing.LevelOne;
import RiverCrossing.Crosser;
import RiverCrossing.ICrosser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Plant extends Crosser implements ICrosser {

    private String label;
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

    @Override
    public ICrosser makeCopy() {
        // TODO Auto-generated method stub
        return null;
    }

    public void setLabelToBeShown(String label) {
        this.label = label;
    }

    @Override
    public String getLabelToBeShown() {
        return label;
    }

    @Override
    public BufferedImage[] getImages() {

        BufferedImage[] bufferedImage = new BufferedImage[2];
        File file1 = new File("cabbage.png");
        try {
            bufferedImage[0] = ImageIO.read(file1);
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        File file2 = new File("cabbage.png");
        try {
            bufferedImage[1] = ImageIO.read(file2);
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        return bufferedImage;
    }
}
