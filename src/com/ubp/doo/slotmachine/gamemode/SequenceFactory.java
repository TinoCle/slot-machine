package com.ubp.doo.slotmachine.gamemode;

public class SequenceFactory implements IGameModeAbstractFactory{
    @Override
    public GameMode createGameMode(){
        return new Sequence();
    }
}
