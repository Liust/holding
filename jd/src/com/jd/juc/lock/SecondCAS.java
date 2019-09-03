package com.jd.juc.lock;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * for A-B-A problem
 * 对于CAS 会存在ABA问题，针对这个问题，可以使用AtomicStampedReference 解决
 */
public class SecondCAS {
    private AtomicStampedReference<Long> counter;
}
