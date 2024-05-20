package inm.or.biz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FoOrderApiApplicationTests {

    private static final Logger logger = LogManager.getLogger(FoOrderApiApplicationTests.class);

    @Test
    void logTest() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            logger.info("Test log entry " + i);
        }
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Logging 10,000 entries took " + duration + " milliseconds");
    }

}
