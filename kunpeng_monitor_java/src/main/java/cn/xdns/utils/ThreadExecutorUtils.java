package cn.xdns.utils;


import org.springframework.stereotype.Component;

import java.util.concurrent.*;


@Component
public class ThreadExecutorUtils {

    private final ExecutorService executor = new ThreadPoolExecutor(
            87, 87, 2, TimeUnit.MINUTES,
            new LinkedBlockingQueue<Runnable>());

    private static final ThreadExecutorUtils threadExecutorUtils = new ThreadExecutorUtils();

    public ExecutorService getExecutor () {
        return executor;
    }
}
