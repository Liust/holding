package com.jd.dp.singleton;

/**
 *
 *
 */
public enum  Singleton08 {
    INSTANCE;

    public void m(){}

    public static void main(String[] args) {
        for(int i = 0;  i< 100; i++){
            new Thread( new Runnable(){
                public void run(){
                  System.out.println(Singleton08.INSTANCE.hashCode());
                }
            }).start();
        }
    }
}
