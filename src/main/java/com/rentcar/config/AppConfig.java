package com.rentcar.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*@Configuration
@EnableTransactionManagement
@PropertySources({@PropertySource("classpath:application.properties")})*/
public class AppConfig {
	
	@Autowired
	private Environment env;
	
	/*@Bean(name = "dataSource")*/
	   public DataSource getDataSource() {
	       DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 
	       // See: application.properties
	       dataSource.setDriverClassName(env.getProperty("spring.datasource.database-driver"));
	       dataSource.setUrl(env.getProperty("spring.datasource.url"));
	       dataSource.setUsername(env.getProperty("spring.datasource.username"));
	       dataSource.setPassword(env.getProperty("spring.datasource.password"));
	 
	       System.out.println("## getDataSource: " + dataSource);
	 
	       return dataSource;
	   }
	
	@Bean(name = "transactionManager")
	   public DataSourceTransactionManager getTransactionManager() {
	       DataSourceTransactionManager txManager = new DataSourceTransactionManager();
	 
	       DataSource dataSource = this.getDataSource();
	       txManager.setDataSource(dataSource);
	 
	       return txManager;
	   }
}
