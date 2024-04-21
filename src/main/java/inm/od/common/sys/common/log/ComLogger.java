package inm.od.common.sys.common.log;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ComLogger {

    public static String logPattern = "%d{yyyy-MM-dd HH:mm:ss} [%t] %-5p %c{1} :::  %msg%n";

    @PostConstruct
    public void init() {
        log.info("ComLogger is ready");

    }

    @Async("loggerExecutor")
    public void info(String message) {
        log.info(message);
    }

    @Async("loggerExecutor")
    public void error(String message) {
        log.error(message);
    }

    @Async("loggerExecutor")
    public void error(String message, Throwable t) {
        log.error(message, t);
    }
}
