package inm.or.common.sys.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "masking")
@Data
public class MaskingConfig {
    private List<String> fields;
}
