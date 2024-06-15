package inm.or.common.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Enumeration;

@Component
public class FeignClientInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest httpServletRequest = attributes.getRequest();
            String useTokenHeader = httpServletRequest.getHeader("X-Use-Token");

            if (useTokenHeader != null && useTokenHeader.equalsIgnoreCase("true")) {
                String cookies = httpServletRequest.getHeader("Cookie");
                if (cookies != null) {
                    String authorization = extractAuthorizationFromCookies(cookies);
                    if (authorization != null) {
                        requestTemplate.header("Authorization", authorization);
                    }
                }
            }
        }
    }

    private String extractAuthorizationFromCookies(String cookies) {
        for (String cookie : cookies.split(";")) {
            if (cookie.trim().startsWith("Authorization=")) {
                return cookie.substring("Authorization=".length()).trim();
            }
        }
        return null;
    }
}