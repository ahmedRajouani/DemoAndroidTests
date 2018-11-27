package com.mytaxi.android_demo.java.com.myTaxiTests.ui.pages;


import com.mytaxi.android_demo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * This class will expose and implement all behaviors and most checks of the DriverActivity
 */
public class DriverPage extends BasePage {

    protected static final String SCREENSHOT_TAG = "DriverPage";

    /**
     * The constructor verifies that we are on the correct page by checking
     * the existence of the unique identifier elements of the page/view
     */
    public DriverPage() {
        onView(withId(R.id.fab)).check(matches(isDisplayed()));
    }

    /**
     * Clicking in call button
     */
    public void call() {

        onView(withId(R.id.fab)).perform(click());

    }
}
