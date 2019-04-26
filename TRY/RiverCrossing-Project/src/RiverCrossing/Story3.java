package RiverCrossing;

import RiverCrossing.ICrosser;
import RiverCrossing.ICrossingStrategy;

import java.util.List;

public class Story3 implements ICrossingStrategy {

    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
                           List<ICrosser> boatRiders) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String[] getInstructions() {
        // TODO Auto-generated method stub
        return null;
    }

}

