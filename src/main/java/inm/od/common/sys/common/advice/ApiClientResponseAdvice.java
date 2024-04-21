package inm.od.common.sys.common.advice;

import inm.od.common.sys.config.MaskingConfig;
import inm.od.common.sys.common.response.ApiClientResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Field;
import java.util.List;

@ControllerAdvice
public class ApiClientResponseAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    private MaskingConfig maskingConfig;
    private List<String> MASKED_FIELDS;

    @PostConstruct
    public void init() {
        MASKED_FIELDS = maskingConfig.getFields();
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 모든 컨트롤러 메서드에 적용
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ApiClientResponse) {
            return body;
        }

        ApiClientResponse<Object> apiClientResponse = new ApiClientResponse<>();
        try {
            maskFields(body);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        apiClientResponse.setBody(body);
        return apiClientResponse;
    }

    private void maskFields(Object obj) throws IllegalAccessException {
        if (obj == null) {
            return;
        }

        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (MASKED_FIELDS.contains(field.getName())) {
                field.setAccessible(true);
                Object value = field.get(obj);
                if (value instanceof String) {
                    String maskedValue = maskString((String) value);
                    field.set(obj, maskedValue);
                }
            }
        }
    }

    private String maskString(String value) {
        if (value == null || value.length() <= 2) {
            return value;
        }
        return value.substring(0, 2) + "****";
    }
}

