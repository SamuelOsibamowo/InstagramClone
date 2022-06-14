package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Register parse models
        ParseObject.registerSubclass(Post.class);



        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Mlda2K9y8IEnN9vyozIfnFKqeRDluEdBvdhoX5X5")
                .clientKey("ipyXHFZpdmhZr4xKQz92u4yXareNKQVMjhtuega1")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
