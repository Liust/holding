package com.jd.dp.singleton;

/**
 *
 * 1 double check
 *
 */
public class Singleton06 {
    private static Singleton06 singleton01;
    private Singleton06(){}

    public static Singleton06 getInstance(){
        if (singleton01 == null) {
            
            synchronized(Singleton06.class) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(singleton01 == null){
                    singleton01 = new Singleton06();
                }
            }
        }

        return singleton01;
    }

    public static void main(String[] args) {
        for(int i = 0;  i< 100; i++){
            new Thread( new Runnable(){
                public void run(){
                  System.out.println(Singleton06.getInstance().hashCode());
                }
            }).start();
        }
    }
}
