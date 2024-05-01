package inm.od.common.sys.config.dasource_divide;

//@Configuration
//@EnableTransactionManagement
//@MapperScan(basePackages = {
//        "inm.od.biz.mapper.mapper3"
//}, sqlSessionFactoryRef = "sqlSessionFactory3")
public class DataSource3Config {

//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.db3")
//    public DataSource dataSource3() {
//        // 첫 번째 데이터소스 설정
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager3() {
//        return new DataSourceTransactionManager(dataSource3());
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory3() throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource3());
//        factoryBean.setTypeAliasesPackage("inm.od.biz.mapper.vo");
//        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/mapper3/*.xml"));
//        factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
//        return factoryBean.getObject();
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate3() throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory3());
//    }
}
