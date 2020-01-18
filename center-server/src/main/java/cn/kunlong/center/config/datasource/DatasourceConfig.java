package cn.kunlong.center.config.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.hbatis.spring.HbatisSqlSessionDaoSupport;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

import cn.kunlong.center.ApplicationConsts;

@Configuration
public class DatasourceConfig extends ApplicationConsts {

	@Qualifier("primaryDataSource")

	@Bean(name = "primaryDataSource", destroyMethod = "close", initMethod = "init")
	@ConfigurationProperties(prefix = "spring.datasource.primary")
	public DataSource primaryDataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		return druidDataSource;
	}

	@Bean(name = "primarySqlSessionFactory")
	@Primary
	public SqlSessionFactory primarySqlSessionFactory(@Qualifier("primaryDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setMapperLocations(resolver.getResources(MYBATIS_MAPPER_LOCATIONS));

		HbatisSqlSessionDaoSupport.setHbatisSessionFactory(bean.getObject());
		return bean.getObject();
	}

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("primarySqlSessionFactory");
		mapperScannerConfigurer.setBasePackage(MYBATIS_BASE_PACKAGE);// 每张表对应的XXMapper.java interface类型的Java文件

		return mapperScannerConfigurer;
	}

	@Bean(name = "primaryTransactionManager")
	@Primary
	public DataSourceTransactionManager primaryTransactionManager(
			@Qualifier("primaryDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}