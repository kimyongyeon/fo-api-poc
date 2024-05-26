package inm.or;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableFeignClients
@EnableAsync
//@ComponentScan(basePackages = {"tony.ai", "inm.or"})
@ServletComponentScan // 이 어노테이션이 필요합니다.
public class FoOrderApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoOrderApiApplication.class, args);
    }

}
