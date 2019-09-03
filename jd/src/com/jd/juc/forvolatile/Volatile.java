package com.jd.juc.forvolatile;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class Volatile implements Runnable{
    private static volatile boolean flag = true;

    public void run() {
        while (flag){
//            log.error("-----------");
        }

        log.error(" is over ", flag);
    }

    public void stop(){
        flag = false;
    }

    public static void main(String[] args) {
        final Volatile avolatile = new Volatile();
        new Thread(avolatile, "aThread").start();

        log.error("main thread is go on");


        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.next();
            if("1".equals(input)){
                new Thread(new Runnable() {
                    public void run() {
                        avolatile.stop();
                    }
                }).start();
                break;
            }

        }

        log.error("main is over");
    }
}

