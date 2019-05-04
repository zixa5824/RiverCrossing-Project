package RiverCrossing.LevelTwo;

import RiverCrossing.ICrosser;
import RiverCrossing.ICrossingStrategy;

import java.util.ArrayList;
import java.util.List;

public class StrategyTwo implements ICrossingStrategy {


    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {

        if (boatRiders.size() > 2) return false;

        double totalWeight = 0;
        for (int i = 0; i < boatRiders.size(); i++) totalWeight += boatRiders.get(i).getWeight();
        if (totalWeight > 100) return false;

        if(boatRiders.size() == 1)
            if (!boatRiders.get(0).canSail())
                return false;

        if(boatRiders.size() == 0) return false;

        return true;

    }

    @Override
    public List<ICrosser> getInitialCrossers() {

        CrossersFactoryStoryTwo factory2 = new CrossersFactoryStoryTwo();
        List<ICrosser> crossers = new ArrayList<ICrosser>();

        crossers.add(factory2.getCrosser("farmer",90));
        crossers.add(factory2.getCrosser("farmer",80));
        crossers.add(factory2.getCrosser("farmer",60));
        crossers.add(factory2.getCrosser("farmer",40));
        crossers.add(factory2.getCrosser("animal",20));
        return crossers;

    }

    @Override
    public String[] getInstructions() {
        String[] statement= {"“Four farmers and their animal need to cross a river in a small boat. The weights of the\n" +
                "farmers are 90 kg, 80 kg,60 kg and 40 kg respectively, and the weight of the animal is\n" +
                "\n" +
                "20 kg.”"};
        return statement;
    }
}
