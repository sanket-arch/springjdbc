package com.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDaoImplement;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.dao"})
public class config {
	
	@Bean(name = {"dataSource"})
	public DriverManagerDataSource getDataSource() {
		
		DriverManagerDataSource driverManagerDataSource= new DriverManagerDataSource();
		
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("Sanket4@");
		
		return driverManagerDataSource;
	}
	
	@Bean(name = {"jdbcTemplate"})
	public JdbcTemplate getJdbcTemplate() {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
				
	}
//	@Bean(name = {"studentDao"})
//	public StudentDaoImplement studentDao() {		
//		StudentDaoImplement studentDao = new StudentDaoImplement(); 
//		studentDao.setJdbcTemplate(getJdbcTemplate());
//		return studentDao;
//	}
}
