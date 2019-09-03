package com.jd.dp.singleton;

public class GreenSingleton {
    private static GreenSingleton greenSingleton = new GreenSingleton();
    private GreenSingleton(){}

    public static GreenSingleton getInstance(){
        return greenSingleton;
    }

    public static void main(String[] args) {
        GreenSingleton g1 = GreenSingleton.getInstance();
        GreenSingleton g2 = GreenSingleton.getInstance();

        System.out.println("g1==g2:" + (g1==g2));
    }
}
