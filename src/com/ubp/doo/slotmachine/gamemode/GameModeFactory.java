package com.ubp.doo.slotmachine.gamemode;

public class GameModeFactory {
    public static GameMode getGameMode(IGameModeAbstractFactory factory){
        return factory.createGameMode();
    }
}