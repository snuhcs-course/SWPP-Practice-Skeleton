package com.example.lab4application;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityUITests {
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void resetButton_click_numRolledZero(){
        onView(withId(R.id.resetButton))
                .perform(click());
        onView(withId(R.id.numRolledTextView))
                .check(matches(withText("0")));
    }

    @Test
    public void rollDiceButton_click_UIchanged(){
        onView(withId(R.id.rollButton)).perform(click());

        // Checks that # rolled displays a number
        // No need to check that the RollButton click increments the value by 1
        // This should be done through unit test of the button's clickHandler
        onView(withId(R.id.numRolledTextView)).check(matches(isDisplayed()));

        // Checks that first dice has a value between 1 ~ 6
        onView(withId(R.id.firstDiceTextView))
                .check(matches(anyOf(withText("1"), withText("2"), withText("3"),
                        withText("4"), withText("5"), withText("6"))));
        // You can also just check that a value is well displayed
        onView(withId(R.id.firstDiceTextView)).check(matches(isDisplayed()));

        // Checks that first dice has a value between 1 ~ 6
        onView(withId(R.id.secondDiceTextView))
                .check(matches(anyOf(withText("1"), withText("2"), withText("3"),
                        withText("4"), withText("5"), withText("6"))));
        // You can also just check that a value is well displayed
        onView(withId(R.id.secondDiceTextView)).check(matches(isDisplayed()));

    }

}
