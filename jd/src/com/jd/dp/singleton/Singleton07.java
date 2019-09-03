package com.jd.dp.singleton;

/**
 *
 * 静态内部类， 加载singleton07 时， 不会加载Holder
 * 执行getInstance时，加载Holder jvm保证只会加载一次
 *
 */
public class Singleton07 {
    private Singleton07(){}

    private static class Holder{
        public static final Singleton07 instance = new Singleton07();
    }

    public static Singleton07 getInstance(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Holder.instance;
    }

    public static void main(String[] args) {
        for(int i = 0;  i< 100; i++){
            new Thread( new Runnable(){
                public void run(){
                  System.out.println(Singleton07.getInstance().hashCode());
                }
            }).start();
        }
    }
}
