package com.jd.dp.singleton;

/**
 *
 * 1 lazy version
 * 2 not init until be used
 *
 */
public class Singleton05 {
    private static Singleton05 singleton01;
    private Singleton05(){}

    public static Singleton05 getInstance(){
        if (singleton01 == null) {

            synchronized(Singleton05.class) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                singleton01 = new Singleton05();
            }
        }

        return singleton01;
    }

    public static void main(String[] args) {
        for(int i = 0;  i< 100; i++){
            new Thread( new Runnable(){
                public void run(){
                  System.out.println(Singleton05.getInstance().hashCode());
                }
            }).start();
        }
    }
}
