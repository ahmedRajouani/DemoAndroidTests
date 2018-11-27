package com.mytaxi.android_demo.java.com.myTaxiTests.ui.pages;


import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;

import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.activities.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * This class will expose and implement all behaviors and most checks of the WelcomeActivity
 */
public class SearchPage extends BasePage {

    protected static final String SCREENSHOT_TAG = "SearchPage";
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    /**
     * The constructor verifies that we are on the correct page by checking
     * the existence of the unique identifier elements of the page/view
     */
    public SearchPage() {

        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
        onView(withId(R.id.textSearch)).check(matches(isDisplayed())).perform(click());

    }

    /**
     * Search for text
     *
     * @param str The string title to search in the page/view
     */
    public void searchText(String str) {

        onView(withId(R.id.textSearch)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.textSearch)).perform(typeText(str), closeSoftKeyboard());
    }

    /**
     * Click on the right name
     *
     * @param name The string name to click in the right driver and return the driver page
     */
    public DriverPage clickResult(String name) {
        onView(withText(name))
                .inRoot(RootMatchers.isPlatformPopup())
                .check(matches(isDisplayed())).perform(click());
        return new DriverPage();
    }
}
