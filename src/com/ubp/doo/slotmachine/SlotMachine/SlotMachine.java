package com.ubp.doo.slotmachine.SlotMachine;

import com.ubp.doo.slotmachine.coin_related.BetManager;
import com.ubp.doo.slotmachine.gamemode.*;
import com.ubp.doo.slotmachine.reel.IReelManagerListener;
import com.ubp.doo.slotmachine.reel.ReelManager;
import com.ubp.doo.slotmachine.record.RecordManager;
import com.ubp.doo.slotmachine.display.Display;
import com.ubp.doo.slotmachine.settings.Settings;
import slotmachine.ui.data.ICredit;
import slotmachine.ui.handler.*;
import slotmachine.ui.view.SlotMachineViewFacade;

import java.util.*;

/*
    3 iguales = *10
    2 iguales = *2
    3 ceros = *100
*/

public class SlotMachine implements ICreditHandler, IDisplayHandler, IGameModeHandler, IPlayHandler,
                                    IPrizeHandler, IReelManagerListener {
    private ReelManager reelManager;
    private RecordManager recordManager;
    public BetManager betManager;

    private GameMode gameMode;
    private Display display;
    private Settings settings;

    private IDisplayHandler iDisplayHandler;
    private IPrizeHandler iPrizeHandler;
    private IReelsHandler iReelsHandler;
    private IGameModeHandler iGameModeHandler;
    private static SlotMachine instance;

    private IRandomize randomize = new Randomize();
    private List<Integer> reelSize = new ArrayList<>();
    private int reelQuantity;

    private SlotMachine() {
        loadConfiguration();
    }

    public static SlotMachine getInstance() {
        if (instance == null) {
            instance = new SlotMachine();
        }
        return instance;
    }

    public void loadConfiguration() {
        Settings settings = Settings.getInstance();

        //TODO comprobar que las settings esten
        /*System.out.println("GameMode: " + settings.getGameMode());
        System.out.println("ReelSize: " + settings.getReelSize());
        System.out.println("DropBox: " + settings.getDropBox());
        System.out.println("ReelQuantity: " + settings.getReelsQuantity());
        System.out.println("SequenceQuantity: " + settings.getSequencesQuantity());*/

        randomize = new Randomize();
        reelSize = new ArrayList<>();
        reelQuantity = settings.getReelsQuantity();

        SlotMachineViewFacade.setReelsQuantity(reelQuantity);

        for (int i = 0; i < reelQuantity; i++) {
            String valor = settings.getReelSize().split(",")[i];
            reelSize.add(Integer.parseInt(valor));
        }
        System.out.println("Settings Cargadas:" + settings.getGameMode());
        //if (settings.getGameMode() == "random") {
        if (settings.getGameMode().equals("random")){
            gameMode = GameModeFactory.getGameMode(new RandomFactory(reelSize, randomize));
        } else {
            gameMode = GameModeFactory.getGameMode(new SequenceFactory(reelSize, settings.getSequencesQuantity(), randomize));
        }
        reelManager = new ReelManager(reelSize);
        reelManager.setListener(this);

        betManager = new BetManager(settings.getDropBox());
    }

    @Override
    public void onReelsFinished() {
        System.out.println("Los reels han terminado de girar");
        this.showResult();
    }

    //Funcion que se dispara cuando se presiona el boton Play
    @Override
    public void play() {
        if (betManager.getBet() >= 5) {
            List<Integer> result = this.gameMode.getNextValues();
            this.setText("Spinning Reels");
            this.reelManager.spinReels(2, result);
        } else {
            iDisplayHandler.setText("Cantidad Insuficiente de Monedas");
            SlotMachineViewFacade.setInputEnabled(false);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    iDisplayHandler.setText("Bet: " + betManager.getBet());
                    SlotMachineViewFacade.setInputEnabled(true);
                }
            }, 2000);
        }
    }

    //Funcion que se usa para mostrar algun mensaje en el Display del GUI
    @Override
    public void setText(String text) {
        iDisplayHandler.setText(text);
    }

    //IPrizeHandler: para mostrar por PayoutTray que ganó
    @Override
    public void retrieve(int prize) {
        iPrizeHandler.retrieve(prize);
    }

    public void setiDisplayHandlerer(IDisplayHandler displayHandler) {
        this.iDisplayHandler = displayHandler;
        betManager.setiDisplayHandler(displayHandler);
    }

    public void setiPrizeHandler(IPrizeHandler iPrizeHandler) {
        this.iPrizeHandler = iPrizeHandler;
    }

    public void setIReelsHandler(IReelsHandler iReelsHandler){
        this.iReelsHandler = iReelsHandler;
        reelManager.setReelHandlers(iReelsHandler.getReelsHandler());
    }

    private void showResult() {
        System.out.println("Resultado: " + reelManager.getResults());
        int result = betManager.getResult(reelManager.getResults());
        if (result > 0) {
            this.iDisplayHandler.setText("GANASTE!!!");
            this.retrieve(result);
            betManager.resetBet();
        } else if (result == -1) {
            this.iDisplayHandler.setText("No hay dinero suficiente en el DropBox");
            this.retrieve(betManager.getBet());
            betManager.resetBet();
        } else {
            this.iDisplayHandler.setText("Perdiste");
            betManager.sendToDropbox();
            this.retrieve(0);
        }
    }

    @Override
    public void addCredit(ICredit credit) {
        betManager.addCoin(credit);
        iDisplayHandler.setText("Bet: " + betManager.getBet());
    }

    //Change GameMode
    @Override
    public String change() {
        Settings settings = Settings.getInstance();
        if (settings.getGameMode().equals("random")) {
            settings.setGameMode("sequence");
            this.gameMode =  GameModeFactory.getGameMode(new SequenceFactory(reelSize, settings.getSequencesQuantity(), randomize));
            return "Random";
        } else {
            settings.setGameMode("random");
            this.gameMode = GameModeFactory.getGameMode(new RandomFactory(reelSize, randomize));
            return "Sequence";
        }
    }

    @Override
    public String getMode() {
        if (Settings.getInstance().getGameMode().equals("random")){
            return "Sequence";
        }
        else
            return "Random";
    }
}
