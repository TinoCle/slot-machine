package com.ubp.doo.slotmachine.SlotMachine;

import com.ubp.doo.slotmachine.coin_related.BetManager;
import com.ubp.doo.slotmachine.gamemode.*;
import com.ubp.doo.slotmachine.reel.IReelManagerListener;
import com.ubp.doo.slotmachine.reel.ReelManager;
import com.ubp.doo.slotmachine.record.RecordManager;
import com.ubp.doo.slotmachine.display.Display;
import com.ubp.doo.slotmachine.settings.Settings;
import slotmachine.ui.data.ICredit;
import slotmachine.ui.handler.IDisplayHandler;
import slotmachine.ui.handler.IPlayHandler;
import slotmachine.ui.handler.IPrizeHandler;
import slotmachine.ui.handler.ICreditHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SlotMachine implements ICreditHandler, IDisplayHandler, IPlayHandler, IPrizeHandler, IReelManagerListener {
    private ReelManager reelManager;
    private RecordManager recordManager;
    public BetManager betManager;

    //TODO: ver si estas 3 clases las dejamos aca o movemos too a BetManager
    /*private CoinSlot coinSlot;
    private PayoutTray payoutTray;
    private DropBox dropBox;*/

    private GameMode gameMode;
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

        if(settings.getGameMode() == "random"){
            gameMode = GameModeFactory.getGameMode(new RandomFactory(reelSize, randomize));
        }
        else{
            gameMode = GameModeFactory.getGameMode(new SequenceFactory(reelSize, settings.getSequencesQuantity(), randomize));
        }

        reelManager = new ReelManager(gameMode, reelQuantity);
        reelManager.setListener(this);

        betManager = new BetManager(settings.getDropBox());
        //dropBox = new DropBox(settings.getDropBox());
    }

    @Override
    public void onReelsFinished(){
        System.out.println("Los reels han terminado de girar");
    }


    //Funcion que se dispara cuando se presiona el boton Play
    @Override
    public void play() {
        if (betManager.getBet() >= 5){
            //play
            reelManager.spinReels();
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
    }

    private void setGameMode(){

    }

    @Override
    public void addCredit(ICredit credit) {
        betManager.addCoin(credit);
        iDisplayHandler.setText("Bet: "+ betManager.getBet());
    }
}
