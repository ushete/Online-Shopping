package com.us.shoppingbackend.conf;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.us.shoppingbackend.**.*" })
@EnableTransactionManagement
public class HibernateConfig {
	final String DB_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	final String DB_DRIVER = "org.h2.Driver";
	final String DB_DIALECT = "org.hibernate.dialect.H2Dialect";
	final String DB_USERNAME = "sa";
	final String DB_PASSWORD = "w4llyl4mb";

	@Bean
	public DataSource getDatasource(){
		final BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(DB_DRIVER);
		ds.setUrl(DB_URL);
		ds.setUsername(DB_USERNAME);
		ds.setPassword(DB_PASSWORD);

		return ds;
	}

	@Bean
	public SessionFactory getSessionFactory(DataSource ds){
		final LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(ds);
		builder.addProperties(getProperties());
		builder.scanPackages("com.us.shoppingbackend.**.*");
		return builder.buildSessionFactory();

	}

	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		return new HibernateTransactionManager(sessionFactory);
	}

	private Properties getProperties(){
		final Properties prop = new Properties();
		prop.put("hibernate.dialect", DB_DIALECT);
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.default_schema", "SHOP");

		return prop;
	}

}
