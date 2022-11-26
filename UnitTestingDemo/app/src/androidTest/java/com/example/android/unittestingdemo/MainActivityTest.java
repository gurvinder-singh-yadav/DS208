package com.example.android.unittestingdemo;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void useAppContext(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.android.unittestingdemo", appContext.getPackageName());
    }
    @Test
    public void btnClick(){
        onView(withId(R.id.et)).perform(typeText("Hello"));
        onView(withId(R.id.btn)).perform(click());
        onView(withId(R.id.tv)).check(matches(withText("HELLO")));
    }

}
