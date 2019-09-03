package com.jd.dp.singleton;

/**
 *
 * 1 lazy version
 * 2 not init until be used
 *
 */
public class Singleton01 {
    private static Singleton01 singleton01;
    private Singleton01(){}

    public Singleton01 getInstance(){
        if(singleton01 == null){
            singleton01 = new Singleton01();
        }

        return singleton01;
    }
}
