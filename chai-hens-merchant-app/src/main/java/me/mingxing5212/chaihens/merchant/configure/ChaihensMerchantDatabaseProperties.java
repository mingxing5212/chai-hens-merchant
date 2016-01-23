package me.mingxing5212.chaihens.merchant.configure;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "chaihens.merchant.dataSource")
public class ChaihensMerchantDatabaseProperties extends HikariConfig {
}
