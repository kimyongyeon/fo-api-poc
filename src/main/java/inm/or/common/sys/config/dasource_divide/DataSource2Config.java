package inm.or.common.sys.config.dasource_divide;

//@Configuration
//@EnableTransactionManagement
//@MapperScan(basePackages = {
//        "inm.od.biz.mapper.mapper2",
//}, sqlSessionFactoryRef = "sqlSessionFactory2")
public class DataSource2Config {

//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.db2")
//    public DataSource dataSource2() {
//        // 첫 번째 데이터소스 설정
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager2() {
//        return new DataSourceTransactionManager(dataSource2());
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory2() throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource2());
//        factoryBean.setTypeAliasesPackage("inm.od.biz.mapper.vo");
//        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/mapper2/*.xml"));
//        factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
//        return factoryBean.getObject();
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate2() throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory2());
//    }
}
