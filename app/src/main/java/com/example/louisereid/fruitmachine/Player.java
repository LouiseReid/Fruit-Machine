package com.example.louisereid.fruitmachine;

/**
 * Created by louisereid on 04/11/2017.
 */

public class Player {

    FruitMachine fruitMachine;

    private String name;
    private int purse;

    public Player(String name, int purse) {
        this.name = name;
        this.purse = purse;
    }

    public String getName() {
        return name;
    }

    public int getPurse() {
        return purse;
    }

    public void setPurse(int purse) {
        this.purse = purse;
    }


    public void spend(int price){
        purse -= price;

    }


}
