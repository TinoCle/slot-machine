package com.ubp.doo.slotmachine.coin_related;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BetManagerTest {

    @Test
    void testGetBet_3Reels_FirstPrize() {
        BetManager betManager = new BetManager(1000);
        CoinSlot coinSlot = new CoinSlot();
        coinSlot.SetCoins(5);
        betManager.setCoinSlot(coinSlot);

        List<String> reelResults = new ArrayList<>();
        reelResults.add("banana");
        reelResults.add("banana");
        reelResults.add("banana");

        int result = betManager.getResult(reelResults);

        int expectResult = 500;

        assertEquals(expectResult,result);
    }

    @Test
    void testGetBet_3Reels_Error_FirstPrize() {
        BetManager betManager = new BetManager(1000);
        CoinSlot coinSlot = new CoinSlot();
        coinSlot.SetCoins(5);
        betManager.setCoinSlot(coinSlot);

        List<String> reelResults = new ArrayList<>();
        reelResults.add("banana");
        reelResults.add("banana");
        reelResults.add("banana");

        int result = betManager.getResult(reelResults);

        int expectResult = 5000;

        assertNotEquals(expectResult,result);
    }

    @Test
    void TestGetBet_3Reels_SecondPrize() {
        BetManager betManager = new BetManager(1000);
        CoinSlot coinSlot = new CoinSlot();
        coinSlot.SetCoins(5);
        betManager.setCoinSlot(coinSlot);

        List<String> reelResults = new ArrayList<>();
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("manzana");

        int result = betManager.getResult(reelResults);

        int expectResult = 50;

        assertEquals(expectResult,result);
    }

    @Test
    void TestGetBet_3Reels_Error_SecondPrize() {
        BetManager betManager = new BetManager(1000);
        CoinSlot coinSlot = new CoinSlot();
        coinSlot.SetCoins(5);
        betManager.setCoinSlot(coinSlot);

        List<String> reelResults = new ArrayList<>();
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("manzana");

        int result = betManager.getResult(reelResults);

        int expectResult = 1234;

        assertNotEquals(expectResult,result);
    }

    @Test
    void TestGetBet_3Reels_ThirdPrize() {
        BetManager betManager = new BetManager(1000);
        CoinSlot coinSlot = new CoinSlot();
        coinSlot.SetCoins(5);
        betManager.setCoinSlot(coinSlot);

        List<String> reelResults = new ArrayList<>();
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("pera");

        int result = betManager.getResult(reelResults);

        int expectResult = 10;

        assertEquals(expectResult,result);
    }

    @Test
    void TestGetBet_3Reels_Error_ThirdPrize() {
        BetManager betManager = new BetManager(1000);
        CoinSlot coinSlot = new CoinSlot();
        coinSlot.SetCoins(5);
        betManager.setCoinSlot(coinSlot);

        List<String> reelResults = new ArrayList<>();
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("pera");

        int result = betManager.getResult(reelResults);

        int expectResult = 1234;

        assertNotEquals(expectResult,result);
    }

    @Test
    void TestGetBet_5Reels_FirstPrize() {
        BetManager betManager = new BetManager(1000);
        CoinSlot coinSlot = new CoinSlot();
        coinSlot.SetCoins(5);
        betManager.setCoinSlot(coinSlot);

        List<String> reelResults = new ArrayList<>();
        reelResults.add("banana");
        reelResults.add("banana");
        reelResults.add("banana");
        reelResults.add("banana");
        reelResults.add("banana");

        int result = betManager.getResult(reelResults);

        int expectResult = 1000;

        assertEquals(expectResult,result);
    }

    @Test
    void TestGetBet_5Reels_Error_FirstPrize() {
        BetManager betManager = new BetManager(1000);
        CoinSlot coinSlot = new CoinSlot();
        coinSlot.SetCoins(5);
        betManager.setCoinSlot(coinSlot);

        List<String> reelResults = new ArrayList<>();
        reelResults.add("banana");
        reelResults.add("banana");
        reelResults.add("banana");
        reelResults.add("banana");
        reelResults.add("banana");

        int result = betManager.getResult(reelResults);

        int expectResult = 1234;

        assertNotEquals(expectResult,result);
    }

    @Test
    void TestGetBet_5Reels_SecondPrize() {
        BetManager betManager = new BetManager(1000);
        CoinSlot coinSlot = new CoinSlot();
        coinSlot.SetCoins(5);
        betManager.setCoinSlot(coinSlot);

        List<String> reelResults = new ArrayList<>();
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("manzana");

        int result = betManager.getResult(reelResults);

        int expectResult = 100;

        assertEquals(expectResult,result);
    }

    @Test
    void TestGetBet_5Reels_Error_SecondPrize() {
        BetManager betManager = new BetManager(1000);
        CoinSlot coinSlot = new CoinSlot();
        coinSlot.SetCoins(5);
        betManager.setCoinSlot(coinSlot);

        List<String> reelResults = new ArrayList<>();
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("manzana");

        int result = betManager.getResult(reelResults);

        int expectResult = 1234;

        assertNotEquals(expectResult,result);
    }

    @Test
    void TestGetBet_5Reels_ThirdPrize() {
        BetManager betManager = new BetManager(1000);
        CoinSlot coinSlot = new CoinSlot();
        coinSlot.SetCoins(5);
        betManager.setCoinSlot(coinSlot);

        List<String> reelResults = new ArrayList<>();
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("pera");

        int result = betManager.getResult(reelResults);

        int expectResult = 50;

        assertEquals(expectResult,result);
    }

    @Test
    void TestGetBet_5Reels_Error_ThirdPrize() {
        BetManager betManager = new BetManager(1000);
        CoinSlot coinSlot = new CoinSlot();
        coinSlot.SetCoins(5);
        betManager.setCoinSlot(coinSlot);

        List<String> reelResults = new ArrayList<>();
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("pera");

        int result = betManager.getResult(reelResults);

        int expectResult = 1234;

        assertNotEquals(expectResult,result);
    }

    @Test
    void TestGetBet_5Reels_FourthPrize() {
        BetManager betManager = new BetManager(1000);
        CoinSlot coinSlot = new CoinSlot();
        coinSlot.SetCoins(5);
        betManager.setCoinSlot(coinSlot);

        List<String> reelResults = new ArrayList<>();
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("kiwi");
        reelResults.add("pera");

        int result = betManager.getResult(reelResults);

        int expectResult = 25;

        assertEquals(expectResult,result);
    }

    @Test
    void TestGetBet_5Reels_Error_FourthPrize() {
        BetManager betManager = new BetManager(1000);
        CoinSlot coinSlot = new CoinSlot();
        coinSlot.SetCoins(5);
        betManager.setCoinSlot(coinSlot);

        List<String> reelResults = new ArrayList<>();
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("kiwi");
        reelResults.add("pera");

        int result = betManager.getResult(reelResults);

        int expectResult = 1234;

        assertNotEquals(expectResult,result);
    }

    @Test
    void testSendToDropbox_Reduce() {
        BetManager betManager = new BetManager(1000);
        CoinSlot coinSlot = new CoinSlot();
        coinSlot.SetCoins(5);
        betManager.setCoinSlot(coinSlot);

        List<String> reelResults = new ArrayList<>();
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("kiwi");
        reelResults.add("pera");

        betManager.getResult(reelResults);

        int result = betManager.getDropBox().getTotalCoin();
        int expectResult = 975;

        assertEquals(result,expectResult);
    }

    @Test
    void testSendToDropbox_Reduce_Error() {
        BetManager betManager = new BetManager(1000);
        CoinSlot coinSlot = new CoinSlot();
        coinSlot.SetCoins(5);
        betManager.setCoinSlot(coinSlot);

        List<String> reelResults = new ArrayList<>();
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("manzana");
        reelResults.add("kiwi");
        reelResults.add("pera");

        betManager.getResult(reelResults);

        int result = betManager.getDropBox().getTotalCoin();
        int expectResult = 1000;

        assertNotEquals(result,expectResult);
    }

    @Test
    void testSendToDropbox_Increase() {
        BetManager betManager = new BetManager(1000);
        CoinSlot coinSlot = new CoinSlot();
        coinSlot.SetCoins(200);
        betManager.setCoinSlot(coinSlot);

        List<String> reelResults = new ArrayList<>();
        reelResults.add("durazno");
        reelResults.add("sandia");
        reelResults.add("manzana");
        reelResults.add("kiwi");
        reelResults.add("pera");

        betManager.getResult(reelResults);

        int result = betManager.getDropBox().getTotalCoin();
        int expectResult = 1200;

        assertEquals(result,expectResult);
    }

    @Test
    void testSendToDropbox_Increase_Error() {
        BetManager betManager = new BetManager(1000);
        CoinSlot coinSlot = new CoinSlot();
        coinSlot.SetCoins(200);
        betManager.setCoinSlot(coinSlot);

        List<String> reelResults = new ArrayList<>();
        reelResults.add("durazno");
        reelResults.add("sandia");
        reelResults.add("manzana");
        reelResults.add("kiwi");
        reelResults.add("pera");

        betManager.getResult(reelResults);

        int result = betManager.getDropBox().getTotalCoin();
        int expectResult = 1000;

        assertNotEquals(result,expectResult);
    }
}