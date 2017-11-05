package com.example.louisereid.fruitmachine;

import java.util.ArrayList;


/**
 * Created by louisereid on 03/11/2017.
 */

public class Runner {


    public static void main(String[] args) {
        Player player = new Player("Louise", 0);
        FruitMachine fruitMachine = new FruitMachine(200, 0, 5, 3);
        Game game = new Game(fruitMachine, player);

            game.playGame();
    }
}
