package com.cybertek.tests.day_7_review;

public class SystemPropertiesExample {
    public static void main(String[] args) {
        // finding which operating system that you are using :
        String property = System.getProperty("os.name");
        System.out.println("property = " + property);
        System.out.println("OS: " + System.getProperty("os.name") + "; Version: " + System.getProperty("os.version"));
    }
}
