package inm.od.common.sys.config;

import com.kyy.cu.common.annotation.MasterMapper;
import com.kyy.cu.common.annotation.SlaveMapper;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(MyBatisInmConfig.class)
public class MapperScannerConfig {

    @Primary
    @Bean
    public MapperScannerConfigurer masterMapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("inm.od.biz.mapper.master");
        configurer.setSqlSessionFactoryBeanName("masterSqlSessionFactory");
        configurer.setAnnotationClass(MasterMapper.class);
        return configurer;
    }

    @Bean
    public MapperScannerConfigurer slaveMapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("inm.od.biz.mapper.slave");
        configurer.setSqlSessionFactoryBeanName("slaveSqlSessionFactory");
        configurer.setAnnotationClass(SlaveMapper.class);
        return configurer;
    }
}
