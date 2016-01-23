package me.mingxing5212.chaihens.merchant;

import me.mingxing5212.chaihens.merchant.data.MerchantMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.velocity.VelocityAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication 
@EnableAutoConfiguration(exclude = { VelocityAutoConfiguration.class })
@MapperScan("me.mingxing5212.chaihens.merchant.data")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}