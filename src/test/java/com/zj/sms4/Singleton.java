package com.zj.sms4;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @className: Singleton
 * @description: TODO 类描述
 * @author: allnas
 * @date: 2020/3/15
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Singleton {
    private static Singleton singleton = null;
    private static ReentrantLock lock = new ReentrantLock();

    public static Singleton getSingleton() {
        if (Objects.isNull(singleton)) {
            lock.lock();
            if (Objects.isNull(singleton)) {
                singleton = new Singleton();
            }
            lock.unlock();
        }

        return singleton;
    }
}
