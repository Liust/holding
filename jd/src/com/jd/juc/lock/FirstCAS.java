package com.jd.juc.lock;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicStampedReference;

public class FirstCAS {// basic cas lock
    private AtomicLong counter = new AtomicLong(0L);

    public void incr(){
        boolean updated = false;

        while (!updated){
            long pre = this.counter.get();
            updated = this.counter.compareAndSet(pre, pre + 1);

        }
    }

    public long count(){
        return this.counter.get();
    }
}
