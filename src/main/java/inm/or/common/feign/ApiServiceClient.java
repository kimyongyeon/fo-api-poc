package inm.or.common.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "apiService", url = "http://localhost:8080/api", configuration = FeignConfig.class)
public interface ApiServiceClient {

    @GetMapping("/rcvFeignSome")
    String getSomeData();
}
