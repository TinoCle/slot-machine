package com.ubp.doo.slotmachine.coin_related;

import slotmachine.ui.data.ICredit;

import java.util.*;

public class BetManager {
    private DropBox dropBox;
    private CoinSlot coinSlot;

    private int bet;
    private int prize;

    public DropBox getDropBox() {
        return dropBox;
    }

    public void setCoinSlot(CoinSlot coinSlot) {
        this.coinSlot = coinSlot;
    }

    public BetManager(int dropBoxAmount) {
        this.dropBox = new DropBox(dropBoxAmount);
        this.coinSlot = new CoinSlot();
    }

    public Integer getBet() {
        this.bet = this.coinSlot.getCoinsInserted();
        return this.bet;
    }

    public void addCoin(ICredit amount) {
        this.coinSlot.AddCoin(amount.getValue());
    }

    public void sendToDropbox() {
        if(prize == 0){
            this.dropBox.saveCoins(this.coinSlot.getCoinsInserted());
        }
        else{
            this.dropBox.saveCoins(-prize);
        }
    }

    public void resetBet(){
        this.coinSlot.setCoinsInserted(0);
    }

    public int getResult(List<String> result) {
        prize = 0;
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
                if (this.dropBox.getTotalCoin() < this.getBet() * 100) {
                    return -1;
                } else {
                    prize = this.getBet() * 100;
                }
            }
            else if (maxFreq == 3) {
                if (this.dropBox.getTotalCoin() < this.getBet() * 10) {
                    return -1;
                } else {
                    prize = this.getBet() * 10;
                }
            }
            else if (maxFreq == 2) {
                if (this.dropBox.getTotalCoin() < this.getBet() * 2) {
                    return -1;
                } else {
                    prize = this.getBet() * 2;
                }
            }
        }
        else if(reelsQuantity==5){
            if (key == "banana" && maxFreq == 5) {
                if (this.dropBox.getTotalCoin() < this.getBet() * 200) {
                    return -1;
                } else {
                    prize = this.getBet() * 200;
                }
            }
            else if (maxFreq == 5) {
                if (this.dropBox.getTotalCoin() < this.getBet() * 20) {
                    return -1;
                } else {
                    prize = this.getBet() * 20;
                }
            }
            else if (maxFreq == 4) {
                if (this.dropBox.getTotalCoin() < this.getBet() * 10) {
                    return -1;
                } else {
                    prize = this.getBet() * 10;
                }
            }
            else if (maxFreq == 3) {
                if (this.dropBox.getTotalCoin() < this.getBet() * 5) {
                    return -1;
                } else {
                    prize = this.getBet() * 5;
                }
            }
        }
        sendToDropbox();
        return prize;
    }
}
