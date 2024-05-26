package inm.or.common.validation;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import tony.ai.common.dto.CommonResponse;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final MessageSource messageSource;
    private final RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    public GlobalExceptionHandler(MessageSource messageSource, RequestMappingHandlerAdapter requestMappingHandlerAdapter) {
        this.messageSource = messageSource;
        this.requestMappingHandlerAdapter = requestMappingHandlerAdapter;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResponse handleValidationExceptions(MethodArgumentNotValidException ex, HandlerMethod handlerMethod) {
        Map<String, String> errors = new HashMap<>();
        Class<?> dtoClass = getDtoClass(handlerMethod);
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            String fieldName = error.getField();
            String message = error.getDefaultMessage();
            String fieldNameValue = getFieldNameValue(dtoClass, fieldName);
            errors.put(fieldName, message.replace("{fieldName}", fieldNameValue));
        }
        return CommonResponse.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message("Validation failed")
                .data(errors)
                .build();
    }

    private Class<?> getDtoClass(HandlerMethod handlerMethod) {
        return handlerMethod.getMethodParameters()[0].getParameterType();
    }

    private String getFieldNameValue(Class<?> clazz, String fieldName) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            FieldName annotation = field.getAnnotation(FieldName.class);
            return annotation != null ? annotation.value() : fieldName;
        } catch (NoSuchFieldException e) {
            return fieldName;
        }
    }
}
