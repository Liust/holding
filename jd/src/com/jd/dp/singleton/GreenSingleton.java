package com.jd.dp.singleton;

public class GreenSingleton {
    private static GreenSingleton greenSingleton = new GreenSingleton();
    private GreenSingleton(){}

    public static GreenSingleton getInstance(){
        return greenSingleton;
    }
}
