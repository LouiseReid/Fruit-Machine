package com.example.louisereid.fruitmachine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by louisereid on 04/11/2017.
 */

public class PlayerTest {

    Player player;

    @Before
    public void before() {
        player = new Player("Louise", 100);
    }

    @Test
    public void purseDecreases(){
        player.spend(10);
        assertEquals(90, player.getPurse());
    }

    @Test
    public void purseIncreases(){
        player.win(50);
        assertEquals(150, player.getPurse());
    }
}
