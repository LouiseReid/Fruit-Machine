package com.example.louisereid.fruitmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static com.example.louisereid.fruitmachine.Symbols.BAR;
import static com.example.louisereid.fruitmachine.Symbols.CHERRY;
import static com.example.louisereid.fruitmachine.Symbols.SEVEN;
import static com.example.louisereid.fruitmachine.Symbols.STAR;
import static com.example.louisereid.fruitmachine.Symbols.STRAWBERRY;
import static org.junit.Assert.assertEquals;

/**
 * Created by louisereid on 03/11/2017.
 */

public class FruitMachineTest {

    FruitMachine fruitMachine;

    @Before
    public void before(){
        fruitMachine = new FruitMachine(1000, 0, 10, 5);
    }

    @Test
    public void hasBank(){
        assertEquals(1000, fruitMachine.getBank());
    }

    @Test
    public void hasPrice(){
        assertEquals(10, fruitMachine.getPrice());
    }

    @Test
    public void canSpin(){
        assertEquals(5, fruitMachine.resultOfSpin().size());
    }
//
//    @Test
//    public void canWin(){
//        FruitMachine spy = Mockito.spy(fruitMachine);
//        ArrayList<Integer> result = new ArrayList<>();
//        result.add(5);
//        result.add(5);
//        result.add(5);
//        Mockito.when(spy.resultOfSpin()).thenReturn(5);
//        assertEquals(5, spy.win2(result);
//    }

    @Test
    public void canWin(){
        ArrayList<Symbols> result = new ArrayList<>();
        result.add(CHERRY);
        result.add(CHERRY);
        result.add(CHERRY);
        assertEquals(3, fruitMachine.spin(result));

    }

    @Test
    public void canLose(){
        ArrayList<Symbols> result = new ArrayList<>();
        result.add(CHERRY);
        result.add(CHERRY);
        result.add(BAR);
        assertEquals(0, fruitMachine.spin(result));
    }

    @Test
    public void canPayout(){
        ArrayList<Symbols> result = new ArrayList<>();
        result.add(CHERRY);
        result.add(CHERRY);
        result.add(CHERRY);
        result.add(CHERRY);
        fruitMachine.payout(fruitMachine.spin(result));
        assertEquals(996, fruitMachine.getBank());
    }

    @Test
    public void canJackpot(){
        ArrayList<Symbols> result = new ArrayList<>();
        result.add(STAR);
        result.add(STAR);
        result.add(STAR);
        result.add(STAR);
        result.add(STAR);
        result.add(STAR);
        fruitMachine.payout(fruitMachine.spin(result));
        assertEquals(0, fruitMachine.getBank());
    }




}
