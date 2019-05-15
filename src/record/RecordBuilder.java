package record;

import java.util.List;

// Se necesita comprobar este Builder

public class RecordBuilder {
    int betAmount;
    List<String> reelResults;
    String gameResult;

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }

    public void setReelResults(List<String> reelResults) {
        this.reelResults = reelResults;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    public RecordBuilder build(){
        return this;
    }

}
