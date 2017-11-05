package com.example.louisereid.fruitmachine;

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
        player = new Player("Louise", 10);
        fruitMachine = new FruitMachine(50, 10, 10, 3);
        game = new Game(fruitMachine, player);
    }




}
