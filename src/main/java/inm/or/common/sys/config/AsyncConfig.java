package inm.or.common.sys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

@Configuration
public class AsyncConfig {

    @Bean(name = "loggerExecutor")
    public ThreadPoolExecutor threadPoolExecutor() {
        int corePoolSize = 10; // 초기 쓰레드 생성수
        int maximumPoolSize = 20; // 최대 쓰레드 생성수
        long keepAliveTime = 60; // 일정시간 동안 작업을 수행하지 않고 대기중 상태일 경우 60초 이후 쓰레드 종료
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
        ThreadFactory threadFactory = new ThreadFactory() {
            private int counter = 1;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "ComLogger-" + counter++);
            }
        };
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                handler
        );

        return executor;
    }
}
