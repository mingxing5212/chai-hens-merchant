package me.mingxing5212.chaihens.merchant.configure;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@org.springframework.context.annotation.Configuration
@EnableConfigurationProperties({ChaihensMerchantDatabaseProperties.class})
@EnableTransactionManagement
public class DatabaseConfiguration {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    ChaihensMerchantDatabaseProperties chaihensMerchantDatabasePool;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Bean
    DataSource dataSource() {
        chaihensMerchantDatabasePool.setPoolName("ChaihensMerchantDatabasePool");
        return new HikariDataSource(chaihensMerchantDatabasePool);
    }

    @Bean
    PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(this.dataSource());
    }

    @Bean
    TransactionTemplate transactionTemplate() {
        return new TransactionTemplate(transactionManager());
    }
}
