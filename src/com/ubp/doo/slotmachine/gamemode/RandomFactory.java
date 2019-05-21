package com.ubp.doo.slotmachine.gamemode;

public class RandomFactory implements IGameModeAbstractFactory{
    @Override 
    public GameMode createGameMode(){
         return new Random();
     }
}
