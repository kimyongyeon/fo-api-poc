package inm.od.common.sys.config;

import inm.od.common.sys.common.interceptor.ApiResponseInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ApiResponseInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-ui.html", "/swagger-resources/**", "/webjars/**", "/v2/api-docs");
    }
}
