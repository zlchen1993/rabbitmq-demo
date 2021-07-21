package com.example.mybatismultiannotationdemo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.mybatismultiannotationdemo.mapper.test2",sqlSessionTemplateRef = "test2SqlSessionTemplate")
public class DataSourceConfig2 {

    @Bean("test2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("test2SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }

    @Bean("test2TransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("test2DataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean("test2SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
