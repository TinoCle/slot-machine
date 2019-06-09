package com.ubp.doo.slotmachine.coin_related;

import slotmachine.ui.data.ICredit;
import slotmachine.ui.handler.IDisplayHandler;

import java.util.*;

public class BetManager implements IDisplayHandler {
    private DropBox dropBox;
    private CoinSlot coinSlot;
    private PayoutTray payoutTray;

    private IDisplayHandler iDisplayHandler;

    public int bet;

    //Seteo el dropbox, coinslot y payoutTray aca y lo saco de SlotMachine
    //TODO: tendriamos que ver si dejamos esto aca, o lo sacamos y hacemos que BetManager se encarge solo
    // de la cantidad apostada
    public BetManager(int dropBoxAmount) {
        this.dropBox = new DropBox(dropBoxAmount);
        this.coinSlot = new CoinSlot();
        this.payoutTray = new PayoutTray();
    }

    public void setiDisplayHandler(IDisplayHandler iDisplayHandler) {
        this.iDisplayHandler = iDisplayHandler;
    }

    //Con esto puedo poner mensajes en el Display del GUI desde la clase BetManager
    @Override
    public void setText(String text) {
        iDisplayHandler.setText(text);
    }

    public Integer getBet() {
        this.bet = this.coinSlot.getCoinsInserted();
        return this.bet;
    }

    public void addCoin(ICredit amount) {
        this.coinSlot.AddCoin(amount.getValue());
    }

    public void sendToDropbox() {
        this.dropBox.saveCoins(this.coinSlot.getCoinsInserted());
        this.coinSlot.SetCoins(0);
    }

    public void resetBet(){
        this.coinSlot.SetCoins(0);
    }

    public int getResult(List<String> result) {
        HashMap<String, Integer> frequency = new HashMap<>();
        for (String tmp : result) {
            Integer count = frequency.get(tmp);
            if (count == null)
                count = 0;
            frequency.put(tmp, count + 1);
        }
        int maxFreq = Collections.max(frequency.values());
        System.out.println(frequency);
        String key="";
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == maxFreq) {
                key = entry.getKey();
                break;
            }
        }
        System.out.println("Key:"+ key +" Freq:"+maxFreq);

        int reelsQuantity = result.size();

        if(reelsQuantity==3){
            if (key == "banana" && maxFreq == 3) {
                //si no hay plata en el dropbox
                if (this.dropBox.getTotalCoin() < this.getBet() * 100) {
                    return -1;
                } else {
                    return this.getBet() * 100;
                }
            }
            // si salio 3 veces otro numero
            else if (maxFreq == 3) {
                if (this.dropBox.getTotalCoin() < this.getBet() * 10) {
                    return -1;
                } else {
                    return this.getBet() * 10;
                }
            }
            // si salio 2 veces otro numero
            else if (maxFreq == 2) {
                if (this.dropBox.getTotalCoin() < this.getBet() * 2) {
                    return -1;
                } else {
                    return this.getBet() * 2;
                }
            }
        }
        else if(reelsQuantity==5){
            if (key == "banana" && maxFreq == 5) {
                //si no hay plata en el dropbox
                if (this.dropBox.getTotalCoin() < this.getBet() * 200) {
                    return -1;
                } else {
                    return this.getBet() * 200;
                }
            }
            // si salio 3 veces otro numero
            else if (maxFreq == 5) {
                if (this.dropBox.getTotalCoin() < this.getBet() * 20) {
                    return -1;
                } else {
                    return this.getBet() * 20;
                }
            }
            // si salio 2 veces otro numero
            else if (maxFreq == 4) {
                if (this.dropBox.getTotalCoin() < this.getBet() * 10) {
                    return -1;
                } else {
                    return this.getBet() * 10;
                }
            }
            else if (maxFreq == 3) {
                if (this.dropBox.getTotalCoin() < this.getBet() * 5) {
                    return -1;
                } else {
                    return this.getBet() * 5;
                }
            }
        }
        return 0;
    }

}
