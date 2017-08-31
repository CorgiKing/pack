package com.yy.main.mybatis;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DataSourceConfig1 {
		
		//数据库1
		@Primary
		@Bean(name = "mySqlDb1")
		@ConfigurationProperties(prefix = "spring.datasource")//帮助@Bean加载了所有有前缀spring.datasource的属性。 
		public DataSource mySqlDb1DataSource(){
			System.out.println("dataSource1");
			return new DruidDataSource();//使用Druid连接池获得数据源
//			return DataSourceBuilder.create().build();
		}
		
		
		
		//数据库2
		@Bean(name = "mySqlDb2")
		@ConfigurationProperties(prefix = "spring.datasource2")
		public DataSource mySqlDb2DataSource(){
			return new DruidDataSource();
//			return DataSourceBuilder.create().build();
		}
		

}
