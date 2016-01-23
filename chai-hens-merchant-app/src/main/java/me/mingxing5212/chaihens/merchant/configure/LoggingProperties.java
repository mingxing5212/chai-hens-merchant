package me.mingxing5212.chaihens.merchant.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "logging")
@Component
public class LoggingProperties {
	private String config;
	public String getConfig() {
		return config;
	}
	public void setConfig(String config) {
		this.config = config;
	}
}