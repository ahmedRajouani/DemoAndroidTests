package com.mytaxi.android_demo.java.com.myTaxiTests.ui.pages;


import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.models.User;
import com.mytaxi.android_demo.utils.network.HttpClient;

import javax.inject.Inject;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * This class will expose and implement all behaviors and most checks of the LoginActivity
 */
public class LoginPage extends BasePage {

    protected static final String SCREENSHOT_TAG = "LoginPage";
    @Inject
    HttpClient mHttpClient;
    User user;


    /**
     * The constructor verifies that we are on the correct page by checking
     * the existence of the unique identifier elements of the page/view
     */
    public LoginPage() {
        onView(withId(R.id.edt_username)).check(matches(isDisplayed()));
    }


    /**
     * Perform the login and return the next Search page/view
     *
     * @param userName Name of the user to login
     * @param password Password of the user to login
     * @return Search page/view
     */
    public SearchPage doLogin(String userName, String password) {
        onView(withId(R.id.edt_username)).check(matches(isDisplayed()));
        onView(withId(R.id.edt_username)).perform(typeText(userName));
        onView(withId(R.id.edt_password)).perform(typeText(password), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        return new SearchPage();
    }


}
