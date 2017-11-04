package com.example.louisereid.fruitmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by louisereid on 03/11/2017.
 */

public class WheelTest {

    Wheel wheel;
    ArrayList<Symbols> testwheel;

    @Before
    public void before(){
        wheel = new Wheel();
        testwheel = new ArrayList<>();
        testwheel.add(Symbols.CHERRY);
        testwheel.add(Symbols.BAR);
    }

    @Test
    public void canGenerateWheel(){
        assertEquals(9, wheel.getSymbols().size());
    }

    @Test
    public void canGetSymbolAtIndex(){
        Wheel wheel = new Wheel(testwheel);
        assertEquals(Symbols.CHERRY, wheel.getSymbolAtIndex(0));
    }

    @Test
    public void getRandomSymbol(){
        Symbols s = wheel.getSymbol();
        assertNotNull(s);
        assert(s instanceof Symbols);
    }

    @Test
    public void getWheelSpinValue(){
        Wheel spy = Mockito.spy(wheel);
        Mockito.when(spy.spinWheel()).thenReturn(Symbols.BAR);
        assertEquals(Symbols.BAR, spy.spinWheel());
    }
}
