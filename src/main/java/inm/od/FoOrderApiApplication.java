package inm.od;

import com.kyy.cu.common.ComLogger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = {"com.kyy.cu.common", "inm.od"})
@MapperScan(basePackages = {"inm.od.biz.mapper"})
public class FoOrderApiApplication {

    public static void main(String[] args) {

        System.setProperty("logPattern", ComLogger.logPattern);

        SpringApplication.run(FoOrderApiApplication.class, args);
    }

}
