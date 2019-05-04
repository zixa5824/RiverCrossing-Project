package RiverCrossing.LevelTwo;

import RiverCrossing.ICrosser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Farmer implements ICrosser {

    private double weight;
    private  boolean sail = true;

    private String label = "Farmer";

    public Farmer(double weight) {this.weight = weight;}

    @Override
    public double getWeight() {return weight;}

    @Override
    public int getEatingRank() {
        return 0;
    }

    @Override
    public BufferedImage[] getImages() throws IOException {

        //get paths of 2 images.
        //but them in a list.
        // return the list.
        File file1 = new File("src//leftFarmer.png");
        File file2 = new File("src//rightFarmer.png");

        BufferedImage img1 = ImageIO.read(file1); ;
        BufferedImage img2 = ImageIO.read(file2); ;


        BufferedImage[] bufferedImageslist = new BufferedImage[2];
        bufferedImageslist[0] = img1;
        bufferedImageslist[1] = img2;

        return bufferedImageslist;
    }

    @Override
    public ICrosser makeCopy() {
        return null;
    }

    @Override
    public boolean canSail() {return sail;}



    @Override
    public String getLabelToBeShown() {
        return label;
    }

    @Override
    public void setLabelToBeShown(String label) {
        this.label = label;
    }
}
