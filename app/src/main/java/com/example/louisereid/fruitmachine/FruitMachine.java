package com.example.louisereid.fruitmachine;

import android.database.CursorJoiner;

import java.util.ArrayList;

import static android.R.attr.value;

/**
 * Created by louisereid on 03/11/2017.
 */

public class FruitMachine {

    private int bank;
    private int winnings;
    private int price;
    private int noOfWheels;
    private ArrayList<Wheel> row;


    public FruitMachine(int bank, int winnings, int price, int noOfWheels) {
        this.bank = bank;
        this.winnings = winnings;
        this.price = price;
        this.noOfWheels = noOfWheels;
        this.row = new ArrayList<>();
        generateMachine();
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public int getPrice() {
        return price;
    }

    public int getNoOfWheels() {
        return noOfWheels;
    }

    public int getWinnings() {
        return winnings;
    }

    public void setWinnings(int winnings) {
        this.winnings = winnings;
    }

    private void generateMachine() {
        for (int i = 0; i < noOfWheels; i++) {
            Wheel wheel = new Wheel();
            row.add(wheel);
        }
    }


    public ArrayList<Symbols> resultOfSpin(){
        ArrayList<Symbols> line = new ArrayList<>();
        for(Wheel wheel :row){
            Symbols symbol = wheel.spinWheel();
            line.add(symbol);
        }
        return line;
    }


    public int spin(ArrayList<Symbols> line) {
        int winnings = 0;
        boolean winningSpin = true;
        Symbols firstWheel = line.get(0);
        for (int i = 1; i < line.size(); i++) {
            if (line.get(i) != firstWheel) {
                winningSpin = false;
            }
        }
        if (winningSpin){
            for(Symbols symbols : line){
                winnings += symbols.getValue();
                if (firstWheel == Symbols.STAR){
                    winnings = bank;

                }

            }
            if (firstWheel == Symbols.STAR) {
                System.out.println("DING! DING! DING! JACKPOT!");
            }
        }
        setWinnings(winnings);
        return this.getWinnings();
    }


    public void payout(int winnings){
        bank -= winnings;
    }

    public void acceptPayment(int payment){
        bank += payment;
    }




//    public int spin2(ArrayList<Integer> resultOfSpin){
//        int firstWheel = resultOfSpin.get(0);
//        int secondWheel = resultOfSpin.get(1);
//        int thirdWheel = resultOfSpin.get(2);
//        if((firstWheel == secondWheel) && (secondWheel == thirdWheel)){
//            return firstWheel;
//        }
//        return 0;
//    }

//    public int spin3(){
//        ArrayList<Symbols> symbols = resultOfSpin();
//        int winnings = 0;
//        for(Symbols s: symbols){
//            for(int i = 0; i < symbols.size(); i++){
//                for(int j = 0; j < symbols.size(); j++){
//                    if(i == j){
//                    }
//                    return winnings += s.getValue();
//                }
//            }
//        }
//        return 0;
//    }


}
