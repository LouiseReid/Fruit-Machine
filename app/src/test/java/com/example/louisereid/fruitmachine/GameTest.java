package com.example.louisereid.fruitmachine;

import android.telephony.gsm.GsmCellLocation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by louisereid on 05/11/2017.
 */

public class GameTest {

    Game game;
    Player player;
    FruitMachine fruitMachine;

    @Before
    public void before(){
        player = new Player("Louise", 20);
        fruitMachine = new FruitMachine(50, 0, 10, 3);
        game = new Game(fruitMachine, player);
    }


    @Test
    public void playerInsertsMoney(){
        game.insertMoney();
        assertEquals(10, player.getPurse());
        assertEquals(60, fruitMachine.getBank());
    }

    @Test
    public void canPlay(){
        assertEquals(true, game.canPlay());
    }

    @Test
    public void cantPlay(){
      assertEquals(false, game.cantPlay());

    }

    @Test
    public void canTopUpFive(){
        game.topUp5();
        assertEquals(25, player.getPurse());
    }

    @Test
    public void canTopUpTen(){
        game.topUp10();
        assertEquals(30, player.getPurse());
    }

    @Test
    public void canTopUpTwenty(){
        game.topUp20();
        assertEquals(40, player.getPurse());
    }

}
