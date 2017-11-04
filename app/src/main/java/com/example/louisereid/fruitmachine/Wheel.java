package com.example.louisereid.fruitmachine;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by louisereid on 03/11/2017.
 */

public class Wheel {

    ArrayList<Symbols> wheel;

    public Wheel(){
        wheel = new ArrayList<>();
        generateWheel();
    }

    public Wheel(ArrayList<Symbols> newSymbols){
        this.wheel = newSymbols;

    }

    public ArrayList<Symbols> getSymbols() {
        return wheel;
    }

    private int getNumberOfSymbols(){
        return wheel.size();
    }

    private void generateWheel(){
        for(Symbols symbol : Symbols.values()){
            wheel.add(symbol);
        }
    }

    public Symbols getSymbolAtIndex(int index){
        return wheel.get(index);
    }

    private int getRandomNumber(){
        Random rand = new Random();
        int listSize = getNumberOfSymbols();
        int random = rand.nextInt(listSize);
        return random;
    }

    public Symbols getSymbol(){
        int index = getRandomNumber();
        return getSymbolAtIndex(index);
    }


//    public int spinWheel(){
//        return getSymbol().getValue();
//    }

    public Symbols spinWheel(){
        return getSymbol();
    }
}
