package RiverCrossing;

import java.util.ArrayList;
import java.util.List;

public class GameEngine implements IRiverCrossingController
{
    private ICrossingStrategy iCrossingStrategy;

    private List<ICrosser> boatCrossers;
    private List<ICrosser> rightBankCrosser;
    private List<ICrosser> leftBankCrossers;
    private String[] instructions;

    //implementing Singleton Design Pattern.
    private static GameEngine gameEngine;
    public static GameEngine getGameEngine()
    {
        if (gameEngine == null)
            gameEngine = new GameEngine();
        return gameEngine;
    }
    private GameEngine()
    {

    }




    @Override
    public void newGame(ICrossingStrategy gameStrategy) {

        boatCrossers = new ArrayList<>();
        rightBankCrosser = new ArrayList<>();
        leftBankCrossers = gameStrategy.getInitialCrossers();
        iCrossingStrategy = gameStrategy;
        instructions = gameStrategy.getInstructions();

    }

    @Override
    public void resetGame() {
        // TODO Auto-generated method stub

    }

    @Override
    public String[] getInstructions() {

        return iCrossingStrategy.getInstructions();
    }

    @Override
    public List<ICrosser> getCrossersOnRightBank() {
        // TODO Auto-generated method stub
        return rightBankCrosser;
    }

    @Override
    public List<ICrosser> getCrossersOnLeftBank() {

        return leftBankCrossers;
    }

    @Override
    public boolean isBoatOnTheLeftBank() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getNumberOfSails() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {

        return iCrossingStrategy.isValid(rightBankCrosser,leftBankCrossers,crossers);
    }

    @Override
    public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean canUndo() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean canRedo() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void undo() {
        // TODO Auto-generated method stub

    }

    @Override
    public void redo() {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveGame() {
        // TODO Auto-generated method stub

    }

    @Override
    public void loadGame() {
        // TODO Auto-generated method stub

    }

    @Override
    public List<List<ICrosser>> solveGame() {
        // TODO Auto-generated method stub
        return null;
    }

}

