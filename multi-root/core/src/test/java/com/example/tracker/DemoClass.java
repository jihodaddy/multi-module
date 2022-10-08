package com.example.tracker;

import com.example.tracker.aop.Monitored;
import com.example.tracker.utils.ThreadUtils;

import java.util.Observer;

/**
 * @author Dima Frid
 */
public class DemoClass {
    private Observer observer;

    @Monitored
    public void topLevelCall(long sleep, long midLevelCallSleep) {
        ThreadUtils.sleep(1000);

        if (observer != null) {
            observer.update(null, null);
        }

        midLevelCall(midLevelCallSleep);
        ThreadUtils.sleep(sleep);
    }

    @Monitored
    public void midLevelCall(long sleep) {
        ThreadUtils.sleep(sleep);
    }

    public void addObserver(Observer observer) {
        this.observer = observer;
    }
}
