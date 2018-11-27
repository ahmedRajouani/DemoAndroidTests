package com.mytaxi.android_demo.java.com.myTaxiTests.util;

import com.mytaxi.android_demo.java.com.myTaxiTests.ui.pages.BasePage;
import com.mytaxi.android_demo.models.Driver;
import com.mytaxi.android_demo.models.User;
import com.mytaxi.android_demo.utils.network.HttpClient;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import javax.inject.Inject;

public class APICall {
    final private ArrayList<Driver> suggestions = new ArrayList<>();
    @Inject
    HttpClient mHttpClient;
    private BasePage mCurrentPage;
    private User user;
    private String nameDriver;

    /**
     * Rest API call for the login and the password
     *
     * @param seed Rest API parameter
     */
    public User invokeUser(String seed) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        mHttpClient = new HttpClient();

        mHttpClient.fetchUser(seed, new HttpClient.UserCallback() {
            @Override
            public void run() {
                if (mUser.getUsername() != null) {

                    user = mUser;
                    countDownLatch.countDown();

                }
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Rest API call for the login and the password
     *
     * @param str contain the search text
     */
    public String invokeDriverName(String str) {
        final CountDownLatch countDownLatchDriver = new CountDownLatch(1);

        mHttpClient.fetchDrivers(new HttpClient.DriverCallback() {
            @Override
            public void run() {
                if (mDrivers.size() != 0) {
                    for (Driver driver : mDrivers) {
                        if (driver.getName().toLowerCase().startsWith(Configuration.searchText().toLowerCase())) {
                            suggestions.add(driver);
                        }
                    }
                    nameDriver = suggestions.get(1).getName();
                    countDownLatchDriver.countDown();

                }
            }
        });
        try {
            countDownLatchDriver.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return nameDriver;
    }

}
