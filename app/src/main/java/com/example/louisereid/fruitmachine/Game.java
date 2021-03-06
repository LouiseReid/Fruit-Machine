package com.example.louisereid.fruitmachine;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by louisereid on 04/11/2017.
 */

public class Game {

    FruitMachine fruitMachine;
    Player player;

    public Game(FruitMachine fruitMachine, Player player) {
        this.fruitMachine = fruitMachine;
        this.player = player;
    }

    public void playGame() {
        while (player.getPurse() > -1) {
            if (canPlay()) {
            }
            if (cantPlay()) {
                System.out.println("You do not have enough funds to play this game!");
                System.out.println("Would you like to topup? (5/10/20)");

                Scanner scanner = new Scanner(System.in);
                String topUp = scanner.nextLine();

                if(topUp.equals("5"))
                    topUp5();
                if (topUp.equals("10"))
                    topUp10();
                if(topUp.equals("20"))
                    topUp20();
                if (topUp.equals("n")) {
                    System.out.println("Okay thanks bye!");
                    break;
                }

            }

            insertMoney();

            ArrayList<Symbols> result = fruitMachine.resultOfSpin();

            try {
                System.out.println();
                for (int i = 0; i < fruitMachine.getNoOfWheels(); i++) {
                    System.out.println(result.get(i));
                    Thread.sleep(2000);
                }
                System.out.println();
                fruitMachine.payout(fruitMachine.spin(result));


                System.out.println("You have won: " + fruitMachine.getWinnings());
                player.setPurse(player.getPurse() + fruitMachine.getWinnings());
                System.out.println("You have " + player.getPurse() + " available");
                System.out.println("Potential Jackpot winnings: " + fruitMachine.getBank());
                Thread.sleep(3000);
                System.out.println();


                if (player.getPurse() > 0) {
                    System.out.println("Would you like to cash out?");
                    Scanner scanner = new Scanner(System.in);
                    String cashOut = scanner.nextLine();

                    if (cashOut.equals("y")) {
                        System.out.println("Thanks for playing, you have cashed out " + player.getPurse());
                        break;
                    }
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

        public void insertMoney(){
            player.spend(fruitMachine.getPrice());
            fruitMachine.setBank(fruitMachine.getBank() + fruitMachine.getPrice());
        }

        public boolean canPlay(){
           return player.getPurse() >= fruitMachine.getPrice();
        }

        public boolean cantPlay(){
            return player.getPurse() < fruitMachine.getPrice();
        }

        public void topUp5(){
            player.setPurse(player.getPurse() + TopUp.FIVE.value);
        }

        public void topUp10(){
        player.setPurse(player.getPurse() + TopUp.TEN.value);
        }

        public void topUp20(){
        player.setPurse(player.getPurse() + TopUp.TWENTY.value);
        }




    }

