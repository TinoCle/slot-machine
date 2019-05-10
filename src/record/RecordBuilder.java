package record;

import java.util.List;

// Se necesita comprobar este Builder

public class RecordBuilder {
    int betAmount;
    List<string> reelResults;
    string gameResult;

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }

    public void setReelResults(List<string> reelResults) {
        this.reelResults = reelResults;
    }

    public void setGameResult(string gameResult) {
        this.gameResult = gameResult;
    }

    public RecordBuilder build(){
        return this;
    }

}
