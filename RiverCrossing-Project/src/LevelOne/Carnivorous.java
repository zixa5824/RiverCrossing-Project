package LevelOne;

import RiverCrossing.Crosser;
import RiverCrossing.ICrosser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Carnivorous extends Crosser implements ICrosser {

    private String label;

    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public int getEatingRank() {
        return 3;
    }

    @Override
    public BufferedImage[] getImages() {

        BufferedImage[] bufferedImage = new BufferedImage[2];
        File file1 = new File("leftWolf.png");
        try {
            bufferedImage[0] = ImageIO.read(file1);
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        File file2 = new File("rightWolf.png");
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

    public void setLabelToBeShown(String label) {
        this.label = label;
    }

    @Override
    public String getLabelToBeShown() {
        return label;
    }

}
