package com.rodavid20.unittestingdemo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MyMathUnitTest {
    @Test
    public void add_isCorrect() {
        MyMath myMath = new MyMath();
        assertEquals(5, myMath.add(2,3));
    }

    @Test
    public void subtract_isCorrect() {
        MyMath myMath = new MyMath();
        assertEquals(-1, myMath.subtract(2,3));
    }

    @Test
    public void add1_isCorrect() {
        MyMath myMath = new MyMath();
        assertEquals(-3, myMath.add(-1,-2));
    }
}