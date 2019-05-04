package RiverCrossing.LevelOne;
import RiverCrossing.AlertBox;
import RiverCrossing.GameEngine;
import RiverCrossing.ICrosser;
import RiverCrossing.ICrossingStrategy;

import java.util.*;

public class StrategyOne implements ICrossingStrategy {

    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
                           List<ICrosser> boatRiders)
    {
        GameEngine gameEngine = GameEngine.getGameEngine();
        if(boatRiders.size() == 0)
        {
            AlertBox.display("SAIL ERROR","No boat Riders");
            return false;
        }
        if(boatRiders.size() == 1)
            if(!boatRiders.get(0).canSail())
            {
                AlertBox.display("SAIL ERROR", boatRiders.get(0).getLabelToBeShown() + " can't sail, Only Farmer can sail.\nPlease Read The Instructions Well");
                return false;
            }
        if(gameEngine.isBoatOnTheLeftBank()){
            for (int i = 0; i < leftBankCrossers.size(); i++) {
                for (int j = 0; j < boatRiders.size() ; j++) {
                    if(leftBankCrossers.get(i).getLabelToBeShown().equalsIgnoreCase(boatRiders.get(j).getLabelToBeShown()))
                    {
                        leftBankCrossers.remove(i);
                    }
                }
            }
            if(leftBankCrossers.size() == 0)    return true;
            else if(leftBankCrossers.size() == 1)    return true;
            else
            for (int i = 0; i < leftBankCrossers.size(); i++) {
                for (int j = 1; j < leftBankCrossers.size() ; j++) {
                    if(Math.abs(leftBankCrossers.get(i).getEatingRank() - leftBankCrossers.get(j).getEatingRank()) == 1) {
                        if (leftBankCrossers.get(i).getEatingRank() > leftBankCrossers.get(j).getEatingRank())
                        {
                            AlertBox.display("You Will Lose", leftBankCrossers.get(i).getLabelToBeShown() + " will eat " + leftBankCrossers.get(j).getLabelToBeShown()+".\nPlease Read Again The INSTRUCTIONS");
                            return false;
                        }
                        else
                        {
                            AlertBox.display("You Will Lose", leftBankCrossers.get(j).getLabelToBeShown() + " will eat " + leftBankCrossers.get(i).getLabelToBeShown()+".\nPlease Read Again The INSTRUCTIONS");
                            return false;
                        }
                    }
                }
            }
        }
        else
        {
            for (int i = 0; i < rightBankCrossers.size(); i++) {
                for (int j = 0; j < boatRiders.size() ; j++) {
                    if(rightBankCrossers.get(i).getLabelToBeShown().equalsIgnoreCase(boatRiders.get(j).getLabelToBeShown()))
                    {
                        rightBankCrossers.remove(i);
                    }
                }
            }
            if(rightBankCrossers.size() == 0)    return true;
            else if(rightBankCrossers.size() == 1)    return true;
            else
                for (int i = 0; i < rightBankCrossers.size(); i++) {
                    for (int j = 1; j < rightBankCrossers.size() ; j++) {
                        if(Math.abs(rightBankCrossers.get(i).getEatingRank() - rightBankCrossers.get(j).getEatingRank()) == 1) {
                            if (rightBankCrossers.get(i).getEatingRank() > rightBankCrossers.get(j).getEatingRank()) {
                                AlertBox.display("You Will Lose", rightBankCrossers.get(i).getLabelToBeShown() + " will eat " + rightBankCrossers.get(j).getLabelToBeShown() + ".\nPlease Read Again The INSTRUCTIONS");
                                return false;
                            } else {
                                AlertBox.display("You Will Lose", rightBankCrossers.get(j).getLabelToBeShown() + " will eat " + rightBankCrossers.get(i).getLabelToBeShown() + ".\nPlease Read Again The INSTRUCTIONS");
                                return false;
                            }
                        }
                    }
                }
        }
        return true;
    }

    @Override
    public List<ICrosser> getInitialCrossers()
    {
        CrossersFactoryStoryOne factory = new CrossersFactoryStoryOne();
        List<ICrosser> iCrossers  = new ArrayList<ICrosser>();
        iCrossers.add(factory.getCrosser("farmer"));
        iCrossers.add(factory.getCrosser("plant"));
        iCrossers.add(factory.getCrosser("HERBIVOROUS"));
        iCrossers.add(factory.getCrosser("Carnivorous"));
        iCrossers.get(0).setLabelToBeShown("Farmer");
        iCrossers.get(1).setLabelToBeShown("Cabbage");
        iCrossers.get(2).setLabelToBeShown("Goat");
        iCrossers.get(3).setLabelToBeShown("Wolf");
        return iCrossers;
    }

    @Override
    public String[] getInstructions() {
        String[] s= {"A farmer wants to cross a river and take with him a \n wolf, a goat, and a cabbage.\nRules:\n\n1) The farmer is the only one who can steer the raft. He can only take one passenger (the wolf, the goat, or the cabbage) in addition to himself\n\n2) If the wolf and the goat are alone on the same riverbank, the wolf will eat the goat.\n\n3) If the goat and the cabbage are alone on the same bank, the goat will eat the cabbage.\n\nHow can the farmer get the wolf, the goat, and the cabbage across the river without any of them being eaten?"};
        return s;
    }

}

