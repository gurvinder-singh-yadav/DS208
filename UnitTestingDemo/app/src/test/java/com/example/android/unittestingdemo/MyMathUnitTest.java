package com.example.android.unittestingdemo;

import static org.junit.Assert.*;
import org.junit.Test;

public class MyMathUnitTest {
    @Test
    public void add_isCorrect(){
        MyMath myMath = new MyMath();
        assertEquals(5,myMath.add(2,3));
    }
    @Test
    public void sub_isCorrect(){
        MyMath myMath = new MyMath();
        assertEquals(-1,myMath.subtract(2,3));
    }
}
