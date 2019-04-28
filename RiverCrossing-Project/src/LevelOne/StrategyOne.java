package LevelOne;
import RiverCrossing.ICrosser;
import RiverCrossing.ICrossingStrategy;

import java.util.*;

public class StrategyOne implements ICrossingStrategy {

    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
                           List<ICrosser> boatRiders) {
        if(boatRiders.size()>2)
            return false;
        if(boatRiders.size()==1)
            if(!boatRiders.get(0).canSail())
                return false;
        if(boatRiders.size()>1)
            if(!(boatRiders.get(0).canSail()||boatRiders.get(1).canSail()))
                return false;



        if(rightBankCrossers.size()>1) {
            for(int i=0;i<rightBankCrossers.size()-1;i++) {
                if(Math.abs(rightBankCrossers.get(i).getEatingRank()-rightBankCrossers.get(i+1).getEatingRank())==1)
                    return false;}
            if(Math.abs(  rightBankCrossers.get(1).getEatingRank()-rightBankCrossers.get(   rightBankCrossers.size()   ).getEatingRank() )==1)
                return false;
        }


        if(leftBankCrossers.size()>1) {
            for(int i=0;i<leftBankCrossers.size()-1;i++) {
                if(Math.abs(leftBankCrossers.get(i).getEatingRank()-leftBankCrossers.get(i+1).getEatingRank())==1)
                    return false;}
            if(Math.abs(  leftBankCrossers.get(1).getEatingRank()-leftBankCrossers.get(   leftBankCrossers.size()  ).getEatingRank() )==1)
                return false;
        }

        return true;

    }

    @Override
    public List<ICrosser> getInitialCrossers()
    {
        CrossersFactoryStoryOne factory=new CrossersFactoryStoryOne();
        List<ICrosser> iCrossers  = new ArrayList<ICrosser>();
        iCrossers.add(factory.getCrosser("HERBIVOROUS"));
        iCrossers.add(factory.getCrosser("plant"));
        iCrossers.add(factory.getCrosser("farmer"));
        iCrossers.add(factory.getCrosser("Carnivorous"));
        return iCrossers;
    }

    @Override
    public String[] getInstructions() {
        String[] s= {"A farmer wants to cross a river and take with him a \n wolf, a goat, and a cabbage.\nRules:\n\n1) The farmer is the only one who can steer the raft. He can only take one passenger (the wolf, the goat, or the cabbage) in addition to himself\n\n2) If the wolf and the goat are alone on the same riverbank, the wolf will eat the goat.\n\n3) If the goat and the cabbage are alone on the same bank, the goat will eat the cabbage.\n\nHow can the farmer get the wolf, the goat, and the cabbage across the river without any of them being eaten?"};
        return s;
    }

}

