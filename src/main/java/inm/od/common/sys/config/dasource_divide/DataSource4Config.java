package inm.od.common.sys.config.dasource_divide;

//@Configuration
//@EnableTransactionManagement
//@MapperScan(basePackages = {
//        "inm.od.biz.mapper.mapper4"
//}, sqlSessionFactoryRef = "sqlSessionFactory4")
public class DataSource4Config {

//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.db4")
//    public DataSource dataSource4() {
//        // 첫 번째 데이터소스 설정
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager4() {
//        return new DataSourceTransactionManager(dataSource4());
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory4() throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource4());
//        factoryBean.setTypeAliasesPackage("inm.od.biz.mapper.vo");
//        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/mapper4/*.xml"));
//        factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
//        return factoryBean.getObject();
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate4() throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory4());
//    }
}