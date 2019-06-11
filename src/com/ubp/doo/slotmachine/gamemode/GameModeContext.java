package com.ubp.doo.slotmachine.gamemode;

import java.util.ArrayList;
import java.util.List;

public class GameModeContext implements IGameModeState{
    private IGameModeState gameModeState;
    private List<Integer> reelSizes;
    private int sequencesQuantity;
    private String gameMode;

    public GameModeContext(){
        reelSizes = new ArrayList<>();
        sequencesQuantity = 10;
    }

    public void setReelSizes(List<Integer> reelSizes) {
        this.reelSizes = reelSizes;
    }

    public void setSequencesQuantity(int sequencesQuantity) {
        this.sequencesQuantity = sequencesQuantity;
    }

    public void setGameMode(String gameMode){
        IRandomize randomize = new Randomize();
        this.gameMode = gameMode;
        if(gameMode.equals("random")){
            gameModeState = GameModeFactory.getGameMode(new RandomFactory(reelSizes,randomize));
        }
        else{
            gameModeState = GameModeFactory.getGameMode(new SequenceFactory(reelSizes,sequencesQuantity,randomize));
        }
    }

    public String getGameMode() {
        return gameMode;
    }

    public String changeGameMode(){
        if(gameMode.equals("random")){
            setGameMode("sequence");
            return "Random";
        }
        else{
            setGameMode("random");
            return "Sequence";
        }
    }

    @Override
    public List<Integer> getNextValues(){
        return gameModeState.getNextValues();
    }
}
