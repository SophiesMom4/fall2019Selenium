package com.cybertek.tests.day_14_test_base_properties_driver;

public class Singleton {
    // make constructor private. so we lock this class to outside world
    private Singleton(){
    }

    private static String string;

    public static String getInstance() {
        if (string == null) { //we have to do thos so we don't open another window everytime
            string = "chrome";

        }
        return string;
    }

}
