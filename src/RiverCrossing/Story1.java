package RiverCrossing;
import java.util.*;

public class Story1 implements ICrossingStrategy  {

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


	/*
an extra function to check a list for a certain instance of plant , herb , carni .. etc depending on the int type
1 for farmer ,2 for plant , 3 for herbi, 4 for carni

public boolean typecheck(List<ICrosser> sample,int type)
{
	for(int i=0;i<sample.size();i++) {
	if((sample.get(i) instanceof Farmer)&&type==1)
		return true;
	if((sample.get(i) instanceof Plant)&&type==2)
					return true;
	if((sample.get(i) instanceof Herbivorous)&&type==3)
		return true;
	if((sample.get(i) instanceof Carnivorous)&&type==4)
		return true;
	}

	return false;

}*/

    @Override
    public List<ICrosser> getInitialCrossers() {
        CrossersFactory factory=new CrossersFactory();

        List<ICrosser> locallist=new ArrayList<ICrosser>();

        locallist.add(factory.getCrosser("HERBIVOROUS"));
        locallist.add(factory.getCrosser("plant"));
        locallist.add(factory.getCrosser("farmer"));
        locallist.add(factory.getCrosser("Carnivorous"));

        return locallist;
    }

    @Override
    public String[] getInstructions() {
        String[] s= {"A farmer want to cross a river and take with him 3 animals a wolf(Carnivorous) , a goat(Herbivorous) , and a cabbage(Plant) ", "1) only the farmer can sail and he can only take 1 passenger","carnivors will eat herbivores and herbivores will eat plants if they are each pair is alone on the river bank"};
        return s;
    }

}

