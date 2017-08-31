package com.yy.main.dbs;

//@Configuration
public class DBConfig {
	
//	//数据库1
//	@Primary
//	@Bean(name = "mySqlDb1")
//	@ConfigurationProperties(prefix = "spring.datasource")//帮助@Bean加载了所有有前缀spring.datasource的属性。 
//	public DataSource mySqlDb1DataSource(){
//		return new DruidDataSource();//使用Druid连接池获得数据源
////		return DataSourceBuilder.create().build();
//	}
//	
//	@Bean(name = "mysqlDb1Template")
//	public JdbcTemplate mySql1JdbcTemplate(@Qualifier("mySqlDb1") DataSource dataSource){
//		return new JdbcTemplate(dataSource);
//	}
//	
//	//数据库2
//	@Bean(name = "mySqlDb2")
//	@ConfigurationProperties(prefix = "spring.datasource2")
//	public DataSource mySqlDb2DataSource(){
//		return new DruidDataSource();
////		return DataSourceBuilder.create().build();
//	}
//	
//	@Bean(name = "mysqlDb2Template")
//	public JdbcTemplate mySql2JdbcTemplate(@Qualifier("mySqlDb2") DataSource dataSource){
//		return new JdbcTemplate(dataSource);
//	}
//	
}
