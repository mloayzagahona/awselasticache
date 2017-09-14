package com.capitalone.ease.web;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Created by nzw118 on 8/29/17.
 */
@Service
@Lazy
public class DemoService {


    @Cacheable(value="awspoccacheredis", key = "{#root.methodName, #key}", unless = "#result == null")
    public Greeting getGreeting(long val, String key) {
        simulateSlowService();
        return new Greeting(val, key);
    }

    private void simulateSlowService() {
        try {
            long time = 5000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
