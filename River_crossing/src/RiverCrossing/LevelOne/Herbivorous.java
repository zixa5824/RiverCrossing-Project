package RiverCrossing.LevelOne;
//import java.awt.image.BufferedImage;

import RiverCrossing.Crosser;
import RiverCrossing.ICrosser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Herbivorous extends Crosser implements ICrosser {

    private String label;

    @Override
    public boolean canSail() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public double getWeight() {
        // TODO Auto-generated method stub
        return weight;
    }

    @Override
    public int getEatingRank() {
        return 2;
    }

    @Override
    public BufferedImage[] getImages() {

        BufferedImage[] bufferedImage = new BufferedImage[2];
        File file1 = new File("leftGoat.png");
        try {
            bufferedImage[0] = ImageIO.read(file1);
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        File file2 = new File("rightGoat.png");
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

