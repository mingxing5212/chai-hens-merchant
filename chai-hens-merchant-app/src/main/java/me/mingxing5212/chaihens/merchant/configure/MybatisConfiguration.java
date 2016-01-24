package me.mingxing5212.chaihens.merchant.configure;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * MybatisAutoConfiguration
 *
 * @author Mingxing Li
 * @date 24/1/16
 */
@Configuration
@AutoConfigureAfter(MybatisAutoConfiguration.class)
public class MybatisConfiguration {

    @PostConstruct
    public void afterConfigurationConstruct(){
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
    }

    @Autowired
    public SqlSessionFactory sqlSessionFactory;
}
