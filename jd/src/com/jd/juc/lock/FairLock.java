package com.jd.juc.lock;

import java.util.ArrayList;
import java.util.List;

public class FairLock {
    private boolean isLocked = false;
    private Thread lockingThread = null;
    private List<QueueObject> waitingThreads = new ArrayList<QueueObject>();

    public void lock(){
        QueueObject queueObject = new QueueObject();

        synchronized (this){
            waitingThreads.add(queueObject);
        }

    }

    public synchronized void unlock(){
        if(lockingThread != Thread.currentThread()){
            throw new IllegalMonitorStateException("Calling thread has not locked this lock");
        }

        this.isLocked = false;
        this.lockingThread = null;
        if(waitingThreads.size() > 0){
            waitingThreads.get(0).doNotify();
        }
    }
}

class QueueObject {
    private boolean isNotified = false;

    public synchronized void doNotify(){
        isNotified = true;
        this.notify();
    }

    public synchronized void doWait() throws InterruptedException{
        while (!isNotified){
            this.wait();
        }

        isNotified = false;

    }
}
