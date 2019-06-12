package com.ubp.doo.slotmachine.SlotMachine;

import com.ubp.doo.slotmachine.coin_related.BetManager;
import com.ubp.doo.slotmachine.gamemode.*;
import com.ubp.doo.slotmachine.reel.IReelManagerListener;
import com.ubp.doo.slotmachine.reel.ReelManager;
import com.ubp.doo.slotmachine.record.RecordManager;
import com.ubp.doo.slotmachine.settings.Settings;
import slotmachine.ui.data.ICredit;
import slotmachine.ui.handler.*;
import slotmachine.ui.view.SlotMachineViewFacade;
import java.util.*;

public class SlotMachine implements ICreditHandler, IDisplayHandler, IPlayHandler,
                                    IPrizeHandler, IReelManagerListener, IGameModeHandler,
                                    IResetHandler{
    private ReelManager reelManager;
    private RecordManager recordManager;
    private BetManager betManager;

    private GameModeContext gameMode;
    private Settings settings;

    private IDisplayHandler iDisplayHandler;
    private IPrizeHandler iPrizeHandler;
    private IReelsHandler iReelsHandler;
    private static SlotMachine instance;

    private IRandomize randomize;
    private List<Integer> reelSize;
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
        settings = Settings.getInstance();
        gameMode = new GameModeContext();

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

        // Usamos el patron de State en SlotMachine
        gameMode.setReelSizes(reelSize);
        gameMode.setSequencesQuantity(settings.getSequencesQuantity());
        gameMode.setGameMode(settings.getGameMode());

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
            recordManager = new RecordManager();
            List<Integer> result = this.gameMode.getNextValues();
            this.setText("Spinning Reels");
            this.reelManager.spinReels(settings.getSpins(), result);
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
            recordManager.saveRecord(betManager.getBet(),result,reelManager.getResults(),"Gano");
            this.iDisplayHandler.setText("GANASTE!!!");
            this.retrieve(result);
        } else if (result == -1) {
            this.iDisplayHandler.setText("No hay dinero suficiente en el DropBox");
            this.retrieve(betManager.getBet());
        } else {
            recordManager.saveRecord(betManager.getBet(),result,reelManager.getResults(),"Perdio");
            this.iDisplayHandler.setText("Perdiste");
            this.retrieve(0);
        }
        betManager.resetBet();
        settings.setDropBox(betManager.getDropBox().getTotalCoin());
        settings.SaveSettings();
        recordManager.showRecords();
    }

    @Override
    public void addCredit(ICredit credit) {
        betManager.addCoin(credit);
        iDisplayHandler.setText("Bet: "+ betManager.getBet());
    }

    //Change GameMode
    @Override
    public String change() {
        String mode = gameMode.changeGameMode();
        settings.setGameMode(gameMode.getGameMode());
        settings.SaveSettings();
        return mode;
    }

    @Override
    public String getMode() {
        if (gameMode.getGameMode().equals("random")){
            return "Sequence";
        }
        else
            return "Random";
    }

    @Override
    public void reset(){
        betManager.getDropBox().setTotalCoin(1000);
        settings.setDropBox(betManager.getDropBox().getTotalCoin());
        gameMode.setGameMode("random");
        settings.setGameMode(gameMode.getGameMode());
        settings.SaveSettings();
    }
}
