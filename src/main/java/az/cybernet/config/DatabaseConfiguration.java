package az.cybernet.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DatabaseConfiguration {
    @Value("${test.datasource.username}")
    private String datasourceUser;
    @Value("${test.datasource.password}")
    private String datasourcePassword;
    @Value("${test.datasource.url}")
    private String datasourceHost;
    @Value("${test.datasource.driver}")
    private String datasourceDriver;

    @Bean
    public DataSource dataSourceSphere() {
        HikariConfig config = new HikariConfig();
        config.setUsername(datasourceUser);
        config.setPassword(datasourcePassword);
        config.setJdbcUrl(datasourceHost);
        config.setDriverClassName(datasourceDriver);
        return new HikariDataSource(config);
    }

}