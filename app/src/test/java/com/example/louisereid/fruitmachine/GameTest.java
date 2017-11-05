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
        Player player1 = new Player("Louise", 2);
        FruitMachine fruitMachine1 = new FruitMachine(50, 0, 10, 3);
        Game game1 = new Game(fruitMachine1, player1);
        assertEquals(false, game1.canPlay());

    }


}
