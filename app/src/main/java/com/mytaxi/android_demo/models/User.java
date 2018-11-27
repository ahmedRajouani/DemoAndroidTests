package com.mytaxi.android_demo.models;

public class User {

    private String mUsername;
    private String mSalt;
    private String mSHA256;
    private String mPassword;

    public User(String username, String salt, String sha256, String password) {
        mUsername = username;
        mSalt = salt;
        mSHA256 = sha256;
        mPassword = password;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getSalt() {
        return mSalt;
    }

    public String getSHA256() {
        return mSHA256;
    }

    public String getPassword() {
        return mPassword;
    }

    public boolean match(String username, String sha256) {
        return (mUsername.equals(username) && mSHA256.equals(sha256));
    }

}
