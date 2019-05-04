package RiverCrossing.LevelTwo;

import RiverCrossing.ICrosser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Animal implements ICrosser {

    private double weight;
    private String label = "Animal";
    private boolean canSail = false;

    public Animal(double weight) {this.weight = weight;}

    @Override
    public boolean canSail() {
        return canSail;
    }

    @Override
    public void setLabelToBeShown(String label) {
        this.label = label;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int getEatingRank() {
        return 0;
    }

    @Override
    public ICrosser makeCopy() {
        return null;
    }

    @Override
    public BufferedImage[] getImages() throws IOException {

        //get paths of 2 images.
        //but them in a list.
        // return the list.
        File file1 = new File("src//leftAnimal.png");
        File file2 = new File("src//rightAnimal.png");

        BufferedImage img1 = ImageIO.read(file1); ;
        BufferedImage img2 = ImageIO.read(file2); ;

        ;


        BufferedImage[] bufferedImageslist = new BufferedImage[2];
        bufferedImageslist[0] = img1;
        bufferedImageslist[1] = img2;

        return bufferedImageslist;
    }


    @Override
    public String getLabelToBeShown() {
        return label;
    }



}
