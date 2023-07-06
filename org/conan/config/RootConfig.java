package org.conan.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@EnableScheduling
@Configuration
@MapperScan(basePackages= {"org.conan.mapper","ezen.exam.mapper"})
@ComponentScan(basePackages= {"ezen.exam.controller","ezen.exam.service","org.conan.controller","org.conan.service", "org.conan.util"})
public class RootConfig {
	
	@Bean //메소드의 실행 결과로 반환된 객체는 스프링 객체로 등록
		public DataSource dataSource() {
		
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:xe");
		hikariConfig.setUsername("hr");
		hikariConfig.setPassword("hr");
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		return dataSource;
		
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		return (SqlSessionFactory) sqlSessionFactory.getObject();
	}
	
}
