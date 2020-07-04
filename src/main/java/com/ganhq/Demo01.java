package com.ganhq;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo01 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();

        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
//        synchronized(o) {
//
//        }
    }
}
