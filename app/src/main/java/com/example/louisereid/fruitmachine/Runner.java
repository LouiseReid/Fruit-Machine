package com.example.louisereid.fruitmachine;

import java.util.ArrayList;


/**
 * Created by louisereid on 03/11/2017.
 */

public class Runner {


    public static void main(String[] args) {
        FruitMachine fruitMachine = new FruitMachine(100, 10, 3);


        ArrayList<Symbols> result = fruitMachine.resultOfSpin();
        try {
            for (int i = 0; i < fruitMachine.getNoOfWheels(); i++) {
                System.out.println(result.get(i));
                Thread.sleep(2000);
            }
            System.out.println("You have won: " + fruitMachine.spin(fruitMachine.resultOfSpin()));
            System.out.println();
            System.out.println("============");
            System.out.println();
            fruitMachine.payout(fruitMachine.spin(fruitMachine.resultOfSpin()));
            System.out.println("Machine Jackpot: " + fruitMachine.getBank());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
