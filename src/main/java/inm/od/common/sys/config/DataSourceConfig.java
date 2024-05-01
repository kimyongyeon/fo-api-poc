package inm.od.common.sys.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScans(value = {
        @MapperScan(basePackages = "inm.od.biz.mapper.mapper1", sqlSessionFactoryRef = "sqlSessionFactory1"),
        @MapperScan(basePackages = "inm.od.biz.mapper.mapper2", sqlSessionFactoryRef = "sqlSessionFactory2"),
        @MapperScan(basePackages = "inm.od.biz.mapper.mapper3", sqlSessionFactoryRef = "sqlSessionFactory3"),
        @MapperScan(basePackages = "inm.od.biz.mapper.mapper4", sqlSessionFactoryRef = "sqlSessionFactory4")
})
public class DataSourceConfig {

    @Bean
    @Lazy
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource dataSource1() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:h2:tcp:localhost/~/testdb1");
        dataSource.setUsername("sa");
        dataSource.setDriverClassName("org.h2.Driver");
        return new LazyConnectionDataSourceProxy(dataSource);
    }
    @Bean
    @Lazy
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource dataSource2() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:h2:tcp:localhost/~/testdb2");
        dataSource.setUsername("sa");
        dataSource.setDriverClassName("org.h2.Driver");
        return new LazyConnectionDataSourceProxy(dataSource);
    }
    @Bean
    @Lazy
    @ConfigurationProperties(prefix = "spring.datasource.db3")
    public DataSource dataSource3() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:h2:tcp:localhost/~/testdb3");
        dataSource.setUsername("sa");
        dataSource.setDriverClassName("org.h2.Driver");
        return new LazyConnectionDataSourceProxy(dataSource);
    }
    @Bean
    @Lazy
    @ConfigurationProperties(prefix = "spring.datasource.db4")
    public DataSource dataSource4() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:h2:tcp:localhost/~/testdb4");
        dataSource.setUsername("sa");
        dataSource.setDriverClassName("org.h2.Driver");
        return new LazyConnectionDataSourceProxy(dataSource);
    }

    @Primary
    @Bean(name = "transactionManager")
    PlatformTransactionManager chainedTransactionManager(
            @Qualifier("transactionManager1") PlatformTransactionManager transactionManager1,
            @Qualifier("transactionManager2") PlatformTransactionManager transactionManager2,
            @Qualifier("transactionManager3") PlatformTransactionManager transactionManager3,
            @Qualifier("transactionManager4") PlatformTransactionManager transactionManager4
    ) {
        return new ChainedTransactionManager(transactionManager1, transactionManager2, transactionManager3, transactionManager4);
    }
    @Bean
    public PlatformTransactionManager transactionManager1(@Qualifier("dataSource1") DataSource dataSource1) {
        // https://devkuka.tistory.com/272
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource1);
        dataSourceTransactionManager.setGlobalRollbackOnParticipationFailure(false);
        return dataSourceTransactionManager;
    }
    @Bean
    public PlatformTransactionManager transactionManager2(@Qualifier("dataSource2") DataSource dataSource2) {
        return new DataSourceTransactionManager(dataSource2);
    }
    @Bean
    public PlatformTransactionManager transactionManager3(@Qualifier("dataSource3") DataSource dataSource3) {
        return new DataSourceTransactionManager(dataSource3);
    }
    @Bean
    public PlatformTransactionManager transactionManager4(@Qualifier("dataSource4") DataSource dataSource4) {
        return new DataSourceTransactionManager(dataSource4);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource1());
        factoryBean.setTypeAliasesPackage("inm.od.biz.mapper.vo");
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/mapper1/*.xml"));
        factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return factoryBean.getObject();
    }
    @Bean
    public SqlSessionFactory sqlSessionFactory2() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource2());
        factoryBean.setTypeAliasesPackage("inm.od.biz.mapper.vo");
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/mapper2/*.xml"));
        factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return factoryBean.getObject();
    }
    @Bean
    public SqlSessionFactory sqlSessionFactory3() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource3());
        factoryBean.setTypeAliasesPackage("inm.od.biz.mapper.vo");
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/mapper3/*.xml"));
        factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return factoryBean.getObject();
    }
    @Bean
    public SqlSessionFactory sqlSessionFactory4() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource4());
        factoryBean.setTypeAliasesPackage("inm.od.biz.mapper.vo");
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/mapper4/*.xml"));
        factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory1());
    }
    @Bean
    public SqlSessionTemplate sqlSessionTemplate2() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory2());
    }
    @Bean
    public SqlSessionTemplate sqlSessionTemplate3() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory3());
    }
    @Bean
    public SqlSessionTemplate sqlSessionTemplate4() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory4());
    }

}
