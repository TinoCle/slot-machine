package com.ubp.doo.slotmachine.coin_related;

import slotmachine.ui.data.ICredit;
import slotmachine.ui.handler.IDisplayHandler;

public class BetManager implements IDisplayHandler {
    private DropBox dropBox;
    private CoinSlot coinSlot;
    private PayoutTray payoutTray;

    private IDisplayHandler iDisplayHandler;

    public int bet;

    //Seteo el dropbox, coinslot y payoutTray aca y lo saco de SlotMachine
    //TODO: tendriamos que ver si dejamos esto aca, o lo sacamos y hacemos que BetManager se encarge solo
    // de la cantidad apostada
    public BetManager(int dropBoxAmount){
        this.dropBox = new DropBox(dropBoxAmount);
        this.coinSlot= new CoinSlot();
        this.payoutTray= new PayoutTray();
    }

    public void setiDisplayHandler(IDisplayHandler iDisplayHandler){
        this.iDisplayHandler=iDisplayHandler;
    }
    //Con esto puedo poner mensajes en el Display del GUI desde la clase BetManager
    @Override
    public void setText(String text) {
        iDisplayHandler.setText(text);
    }

    public Integer getBet(){
        this.bet = this.coinSlot.getCoinInserted();
        return this.bet;
    }

    public void addCoin(ICredit amount){
        this.coinSlot.AddCoin(amount);
    }

}
