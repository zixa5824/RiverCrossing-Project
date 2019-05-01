package RiverCrossing;

import java.util.ArrayList;
import java.util.List;

public class GameEngine implements IRiverCrossingController
{
    private ICrossingStrategy iCrossingStrategy;
    private boolean left;
    private List<ICrosser> rightBankCrosser;
    private List<ICrosser> leftBankCrossers;
    private String[] instructions;
    private int moves;
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

        rightBankCrosser = new ArrayList<>();
        leftBankCrossers = gameStrategy.getInitialCrossers();
        iCrossingStrategy = gameStrategy;
        instructions = gameStrategy.getInstructions();
        left = true;
        moves = 0;
    }

    @Override
    public void resetGame() {
        newGame(iCrossingStrategy);
    }

    @Override
    public String[] getInstructions() {

        return iCrossingStrategy.getInstructions();
    }

    @Override
    public List<ICrosser> getCrossersOnRightBank() {
        return rightBankCrosser;
    }

    @Override
    public List<ICrosser> getCrossersOnLeftBank() {
        return leftBankCrossers;
    }

    @Override
    public boolean isBoatOnTheLeftBank() {
        return left;
    }

    @Override
    public int getNumberOfSails() {
        return moves;
    }

    @Override
    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {

        return iCrossingStrategy.isValid(rightBankCrosser,leftBankCrossers, crossers);
    }

    @Override
    public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank)
    {
        if(fromLeftToRightBank)
        {
            for (int i = 0; i < crossers.size() ; i++)
            {
                rightBankCrosser.add(crossers.get(i));
                leftBankCrossers.remove(crossers.get(i));
            }
        }
        else
        {
            for (int i = 0; i < crossers.size() ; i++)
            {
                leftBankCrossers.add(crossers.get(i));
                rightBankCrosser.remove(crossers.get(i));
            }
        }
        moves++;
        left = false;
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

