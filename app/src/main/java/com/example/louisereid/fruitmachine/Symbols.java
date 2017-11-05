package com.example.louisereid.fruitmachine;

/**
 * Created by louisereid on 03/11/2017.
 */

public enum Symbols {

    CHERRY(1),
//    BELL(2),
//    BAR(3),
//    LEMON(4),
//    DIAMOND(5),
//    STRAWBERRY(6),
//    SEVEN(7),
//    WATERMELON(8),
    STAR(9);

    public int value;


    Symbols(int value) {
        this.value = value;

    }

    public int getValue() {
        return value;
    }



}
