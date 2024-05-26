package inm.or.common.processExample.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        // 초기화 코드 (필요 시)
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("Filter: " + req.getRequestURI());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 정리 코드 (필요 시)
    }
}
