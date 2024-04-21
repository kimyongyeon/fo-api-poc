package inm.od.common.sys.common.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import inm.od.common.sys.common.context.ApiResponseContext;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.WriteListener;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

@Log4j2
public class ApiResponseInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object transactionId = ApiResponseContext.getTransactionId();
        log.info("ApiResponseInterceptor preHandle: {}", transactionId);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Object transactionId = ApiResponseContext.getTransactionId();
        log.info("ApiResponseInterceptor postHandle: {}", transactionId);

//        PrintWriter writer = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
//        writer.print(objectMapper.writeValueAsString(transactionId));

        // 기존 응답을 래핑합니다.
        MyResponseWrapper responseWrapper = new MyResponseWrapper(response);

        // 래핑된 응답 객체를 사용하여 응답 본문을 수정하거나 새로운 응답 본문을 작성합니다.
        responseWrapper.getWriter().write(objectMapper.writeValueAsString("body hello delete"));

        // 래핑된 응답 객체의 내용을 원래 응답 객체로 복사합니다.
        responseWrapper.copyBodyToResponse();

        log.info("ApiResponseInterceptor postHandle");
    }

    // HttpServletResponseWrapper를 상속받는 커스텀 래퍼 클래스
    private static class MyResponseWrapper extends HttpServletResponseWrapper {
        private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        private final PrintWriter writer = new PrintWriter(outputStream);

        public MyResponseWrapper(HttpServletResponse response) {
            super(response);
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return new ServletOutputStream() {
                @Override
                public boolean isReady() {
                    return true;
                }

                @Override
                public void setWriteListener(WriteListener writeListener) {
                }

                @Override
                public void write(int b) throws IOException {
                    outputStream.write(b);
                }
            };
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return writer;
        }

        public void copyBodyToResponse() throws IOException {
            outputStream.writeTo(super.getOutputStream());
        }
    }
}
