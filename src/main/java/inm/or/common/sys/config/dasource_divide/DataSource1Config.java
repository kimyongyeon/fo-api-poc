package inm.or.common.sys.config.dasource_divide;

//@Configuration
//@EnableTransactionManagement
//@MapperScan(basePackages = {
//        "inm.od.biz.mapper.mapper1"
//}, sqlSessionFactoryRef = "sqlSessionFactory1")
//
//@MapperScans(value = {
//        @MapperScan(basePackages = "inm.od.biz.mapper.mapper1", sqlSessionFactoryRef = "sqlSessionFactory1"),
//        @MapperScan(basePackages = "inm.od.biz.mapper.mapper2", sqlSessionFactoryRef = "sqlSessionFactory2"),
//        @MapperScan(basePackages = "inm.od.biz.mapper.mapper3", sqlSessionFactoryRef = "sqlSessionFactory3"),
//        @MapperScan(basePackages = "inm.od.biz.mapper.mapper4", sqlSessionFactoryRef = "sqlSessionFactory4")
//})
public class DataSource1Config {

//    @Primary
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.db1")
//    public DataSource dataSource1() {
//        // 첫 번째 데이터소스 설정
//        return DataSourceBuilder.create().build();
//    }
//
//    @Primary
//    @Bean
//    public PlatformTransactionManager transactionManager1() {
//        return new DataSourceTransactionManager(dataSource1());
//    }
//
//    @Primary
//    @Bean
//    public SqlSessionFactory sqlSessionFactory1() throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource1());
//        factoryBean.setTypeAliasesPackage("inm.od.biz.mapper.vo");
//        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/mapper1/*.xml"));
//        factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
//        return factoryBean.getObject();
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory1());
//    }
}
