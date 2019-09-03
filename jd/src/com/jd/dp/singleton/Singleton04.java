package com.jd.dp.singleton;

/**
 *
 * 1 lazy version
 * 2 not init until be used
 *
 */
public class Singleton04 {
    private static Singleton04 singleton01;
    private Singleton04(){}

    public synchronized static Singleton04 getInstance(){
        if(singleton01 == null){
            try{
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            singleton01 = new Singleton04();
        }

        return singleton01;
    }

    public static void main(String[] args) {
        for(int i = 0;  i< 100; i++){
            new Thread( new Runnable(){
                public void run(){
                  System.out.println(Singleton04.getInstance().hashCode());
                }
            }).start();
        }
    }
}
