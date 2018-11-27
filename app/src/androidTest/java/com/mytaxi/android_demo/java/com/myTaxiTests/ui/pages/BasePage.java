package com.mytaxi.android_demo.java.com.myTaxiTests.ui.pages;

/**
 * Contain the basic behavior logic and checks shared across all pages/views
 */
public class BasePage {


    public <T extends BasePage> T isPage(Class<T> type) {
        if (type.isInstance(this)) {
            return type.cast(this);
        } else {

            throw new InvalidPageException("Invalid page type. Expected: " + type.getSimpleName() + ", but got: " + this.getClass().getSimpleName());
        }
    }

    public static class InvalidPageException extends RuntimeException {

        public InvalidPageException(final String message) {
            super(message);
        }
    }
}
