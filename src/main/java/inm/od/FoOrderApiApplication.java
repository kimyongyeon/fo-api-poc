package inm.od;

//import com.kyy.cu.common.ComLogger;

import inm.od.common.sys.common.log.ComLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableFeignClients
@EnableAsync
//@ComponentScan(basePackages = {"com.kyy.cu.common", "inm.od"})
//@MapperScan(basePackages = {"inm.od.biz.mapper"})
@ServletComponentScan
public class FoOrderApiApplication {

    public static void main(String[] args) {

//        System.setProperty("logPattern", ComLogger.logPattern);

        ComLogger.logInfo(" 이거 맞나요? ");

        SpringApplication.run(FoOrderApiApplication.class, args);
    }

}
