package com.jd.juc.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class PoolThread extends Thread{
    AtomicLong counter = new AtomicLong(0L);
    private boolean isStop = false;
    private BlockingQueue blockTasks = null;






    private PoolThread(){}

    public static PoolThread getInstance(){
        return null;
    }

    public void incr(){
        boolean updated = false;

        while (!updated){// CAS
            long pre = counter.get();
            updated = counter.compareAndSet(pre, pre + 1);
        }
    }
}
