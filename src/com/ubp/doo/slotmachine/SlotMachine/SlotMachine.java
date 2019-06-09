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
import slotmachine.ui.view.IGameModeView;

import java.util.*;


/*
    3 iguales = *10
    2 iguales = *2
    3 ceros = *100
*/

public class SlotMachine implements ICreditHandler, IDisplayHandler, IPlayHandler, IPrizeHandler, IReelManagerListener, IGameModeHandler {
    private ReelManager reelManager;
    private RecordManager recordManager;
    private BetManager betManager;

    //TODO: ver si estas 3 clases las dejamos aca o movemos too a BetManager
    /*private CoinSlot coinSlot;
    private PayoutTray payoutTray;
    private DropBox dropBox;*/

    private GameModeContext gameMode;
    private Display display;
    private Settings settings;

    private IDisplayHandler iDisplayHandler;
    private IPrizeHandler iPrizeHandler;
    private static SlotMachine instance;

    private int betAmount;

    private SlotMachine(){
        loadConfiguration();
    }

    public static SlotMachine getInstance(){
        if(instance==null){
            instance = new SlotMachine();
        }
        return instance;
    }

    public void loadConfiguration(){
        Settings settings = Settings.getInstance();
        gameMode = new GameModeContext();

        //TODO comprobar que las settings esten
        /*System.out.println("GameMode: " + settings.getGameMode());
        System.out.println("ReelSize: " + settings.getReelSize());
        System.out.println("DropBox: " + settings.getDropBox());
        System.out.println("ReelQuantity: " + settings.getReelsQuantity());
        System.out.println("SequenceQuantity: " + settings.getSequencesQuantity());*/

        IRandomize randomize = new Randomize();
        List<Integer> reelSize = new ArrayList<>();

        int reelQuantity = settings.getReelsQuantity();

        for(int i=0;i<reelQuantity;i++){
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
    public void onReelsFinished(){
        System.out.println("Los reels han terminado de girar");
    }

    //Funcion que se dispara cuando se presiona el boton Play
    @Override
    public void play() {
        if (betManager.getBet() >= 5){
            recordManager = new RecordManager();
            reelManager.spinReels(gameMode.getNextValues());
            iDisplayHandler.setText("AAAAAAA");
            this.showResult();
        }
        else{
            iDisplayHandler.setText("Cantidad Insuficiente de Monedas");
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    iDisplayHandler.setText("Bet: " + betManager.getBet());
                }
            }, 2000);
        }
    }

    //Funcion que se usa para mostrar algun mensaje en el Display del GUI
    @Override
    public void setText(String text) {
        iDisplayHandler.setText(text);
    }

    @Override
    public void retrieve(int prize) {
        iDisplayHandler.setText("Prize: " + prize);
        iPrizeHandler.retrieve(prize);
    }

    public void setDisplayHander(IDisplayHandler displayHandler){
        this.iDisplayHandler = displayHandler;
        betManager.setiDisplayHandler(displayHandler);
    }

    public void setiPrizeHandler (IPrizeHandler iPrizeHandler){
        this.iPrizeHandler = iPrizeHandler;
    }

    public void showResult(){
        System.out.println("Resultado: " + reelManager.getResults());
        int result = betManager.getResult(reelManager.getResults());
        System.out.println("Result:"+result);
        if (result>0){
            recordManager.saveRecord(betManager.getBet(),result,reelManager.getResults(),"Gano");
            this.iDisplayHandler.setText("GANASTE!!!");
            this.retrieve(result);
            betManager.resetBet();
        }
        else if (result==-1){
            this.iDisplayHandler.setText("No hay dinero suficiente en el DropBox");
            this.retrieve(betManager.getBet());
            betManager.resetBet();
        }
        else {
            recordManager.saveRecord(betManager.getBet(),result,reelManager.getResults(),"Perdio");
            this.iDisplayHandler.setText("Perdiste");
            betManager.sendToDropbox();
            this.retrieve(0);
        }
        recordManager.showRecords();
        iDisplayHandler.setText(gameMode.getGameMode());
    }

    @Override
    public void addCredit(ICredit credit) {
        betManager.addCoin(credit);
        iDisplayHandler.setText("Bet: "+ betManager.getBet());
    }

    //Change GameMode
    @Override
    public String change() {
        return gameMode.changeGameMode();
    }

    @Override
    public String getMode() {
        if (gameMode.getGameMode().equals("random")){
            return "Sequence";
        }
        else
            return "Random";
    }
}
