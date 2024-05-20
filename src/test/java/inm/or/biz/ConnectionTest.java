package inm.or.biz;


import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootTest
public class ConnectionTest {

    private String url = "jdbc:postgresql://192.168.0.2:5432/postgres?currentSchema=inm1";
    private String userName = "postgres";
    private String password = "1234";

    @Test
    public void testConnection() throws SQLException {
        Connection connection1 = DriverManager.getConnection(url, userName, password);
        Connection connection2 = DriverManager.getConnection(url, userName, password);

        System.out.println("connection1 = " + connection1);
        System.out.println("connection2 = " + connection2);
    }

    @Test
    void dataSourceDriverManager() throws SQLException {
        // 인터페이스를 통해서 가져온다.
        // 설정과 사용의 분리 : 향후 변경에 유연해 진다.
        var datasource = new DriverManagerDataSource(url, userName, password);
        useDataSource(datasource);
    }

    @Test
    void dataSourceConnectionPool() throws SQLException, InterruptedException {
        // 커넥션풀링
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(url);
        dataSource.setMaximumPoolSize(10); // 스펙에 따라 성능 테스트시 늘려야 한다.
        dataSource.setConnectionTimeout(10000); // 짧게 가져가는게 좋다.
//        dataSource.setMinimumIdle(5);
//        dataSource.setIdleTimeout(10000);
        dataSource.setPoolName("hikari-pool");

        useDataSource(dataSource);

        Thread.sleep(1000);
    }

    private void useDataSource(DataSource dataSource) throws SQLException {
        var con1 = dataSource.getConnection();
        var con2 = dataSource.getConnection();
        var con3 = dataSource.getConnection();
        var con4 = dataSource.getConnection();
        var con5 = dataSource.getConnection();
        var con6 = dataSource.getConnection();
        var con7 = dataSource.getConnection();
        var con8 = dataSource.getConnection();
        var con9 = dataSource.getConnection();
        var con10 = dataSource.getConnection();
//        var con11 = dataSource.getConnection();

        System.out.println("con1 = " + con1);
        System.out.println("con2 = " + con2);

    }
}
