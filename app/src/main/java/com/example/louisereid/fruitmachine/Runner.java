package com.example.louisereid.fruitmachine;

import java.util.ArrayList;


/**
 * Created by louisereid on 03/11/2017.
 */

public class Runner {


//    public static void main(String[] args) {
//        FruitMachine fruitMachine = new FruitMachine(100, 0, 10, 3);
//
//
//        ArrayList<Symbols> result = fruitMachine.resultOfSpin();
//
//        try {
//            for (int i = 0; i < fruitMachine.getNoOfWheels(); i++) {
//                System.out.println(result.get(i));
//                Thread.sleep(2000);
//            }
//            System.out.println();
//            System.out.println();
//            System.out.println("============");
//            System.out.println();
//            fruitMachine.payout(fruitMachine.spin(fruitMachine.resultOfSpin()));
//            System.out.println(fruitMachine.setWinnings(fruitMachine.spin(fruitMachine.resultOfSpin()));
//            System.out.println("You have won: " + fruitMachine.getWinnings());
//            System.out.println("Machine Jackpot: " + fruitMachine.getBank());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        Player player = new Player("Louise", 50);
        FruitMachine fruitMachine = new FruitMachine(200, 0, 10, 3);
        Game game = new Game(fruitMachine, player);

        while (player.getPurse() > 0) {
            game.playGame();
        }
    }
}
