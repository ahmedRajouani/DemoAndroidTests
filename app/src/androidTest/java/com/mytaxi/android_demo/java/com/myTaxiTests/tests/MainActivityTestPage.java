package com.mytaxi.android_demo.java.com.myTaxiTests.tests;


import android.content.Context;
import android.support.test.espresso.IdlingResource;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.android_demo.java.com.myTaxiTests.ui.pages.BasePage;
import com.mytaxi.android_demo.java.com.myTaxiTests.ui.pages.LoginPage;
import com.mytaxi.android_demo.java.com.myTaxiTests.ui.pages.SearchPage;
import com.mytaxi.android_demo.java.com.myTaxiTests.util.APICall;
import com.mytaxi.android_demo.java.com.myTaxiTests.util.Configuration;
import com.mytaxi.android_demo.models.User;
import com.mytaxi.android_demo.utils.network.HttpClient;
import com.mytaxi.android_demo.utils.storage.SharedPrefStorage;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTestPage {
    @Rule
    public final ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");
    @Inject
    HttpClient mHttpClient;
    @Inject
    SharedPrefStorage mSharedPrefStorage;
    private BasePage mCurrentPage;
    private User user;
    private String nameDriver;
    private IdlingResource mIdlingResource;

    @Before
    public void setUp() {
    }

    @Test
    public void TestMyTaxiDemo() {

        //Get the User username and password
        APICall APIIns = new APICall();
        user = APIIns.invokeUser(Configuration.seedUser());


        //Get the page object LoginPage
        mCurrentPage = new LoginPage();

        //Authenticate and click login Button
        mCurrentPage = mCurrentPage.isPage(LoginPage.class).doLogin(user.getUsername(), user.getPassword());

        //Open the search page and type Sa
        ((SearchPage) mCurrentPage).searchText(Configuration.searchText());

        //Get the second Driver
        nameDriver = APIIns.invokeDriverName(Configuration.searchText());
        //Click on the second driver and open the driver then click on call
        ((SearchPage) mCurrentPage).clickResult(nameDriver).call();

    }


    @After
    public void tearDown() {

        //Log out
        Context mContext = mActivityTestRule.getActivity().getApplication().getApplicationContext();
        mSharedPrefStorage = new SharedPrefStorage(mContext);
        mSharedPrefStorage.resetUser();
    }


}
