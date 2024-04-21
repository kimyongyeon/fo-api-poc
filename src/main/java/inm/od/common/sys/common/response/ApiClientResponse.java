package inm.od.common.sys.common.response;

import lombok.Data;

@Data
public class ApiClientResponse <T> {
    int statusCode;
    int messageCode;
    String message;
    T body;
}
