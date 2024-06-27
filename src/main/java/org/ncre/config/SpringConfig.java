package org.ncre.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"org.ncre.service"})
@Import({JdbcConfig.class,MyBatisConfig.class})
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {
}

