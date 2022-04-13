package com.example.toyboard.config;

import org.hibernate.cfg.Environment;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Properties;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = {
        "com.example.toyboard.dao",
        "com.example.toyboard.domain"
},considerNestedRepositories = true)
public class DataConfig {

    private static final Logger logger = LoggerFactory.getLogger(DataConfig.class);

    @Value("${spring.datasource.hikari.driver-class-name}")
    String DB_DRIVER;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    String DB_DIALECT;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    String DB_DDL_AUTO;

    @Value("${spring.datasource.hikari.jdbc-url}")
    String DB_URL;

    @Value("${spring.datasource.hikari.username}")
    String DB_USER_NAME;

    @Value("${spring.datasource.hikari.password}")
    String DB_PASSWORD;

    @Primary
    @Bean(name="dataSource")
    public DriverManagerDataSource dataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USER_NAME);
        dataSource.setPassword(DB_PASSWORD);

        logger.info("####################################################################################################################");
        logger.info("# GROUP DataSource Info.");
        logger.info("Driver   :    {}", DB_DRIVER);
        logger.info("Dialect  :    {}", DB_DIALECT);
        logger.info("URL      :    {}", DB_URL);
        logger.info("USERNAME :    {}", DB_USER_NAME);
        logger.info("PASSWORD :    {}", DB_PASSWORD);
        logger.info("####################################################################################################################");

        return dataSource;
    }

    @Bean(name="jpaProperties")
    public Properties jpaProperties(){
        Properties prop = new Properties();
        prop.setProperty(Environment.SHOW_SQL, "true");
        prop.setProperty(Environment.FORMAT_SQL, "true");
        prop.setProperty(Environment.DIALECT, DB_DIALECT);
        prop.setProperty(Environment.DRIVER, DB_DRIVER);
        prop.setProperty(Environment.URL, DB_URL);
        prop.setProperty(Environment.USER, DB_USER_NAME);
        prop.setProperty(Environment.PASS, DB_PASSWORD);
        prop.setProperty(Environment.HBM2DDL_AUTO, DB_DDL_AUTO);
        prop.setProperty(Environment.ENABLE_LAZY_LOAD_NO_TRANS,"true"); //Lazy 문제로 인한 추가 속성
        prop.setProperty("spring.data.jpa.repositories.enabled","true");
        prop.setProperty(Environment.CONNECTION_PROVIDER,"org.hibernate.service.jdbc.connections.internal.C3P0ConnectionProvider"); // org.hibernate / hibernate-c3p0 필요
        prop.setProperty(Environment.C3P0_MIN_SIZE,"10");
        prop.setProperty(Environment.C3P0_MAX_SIZE,"15");
        prop.setProperty(Environment.C3P0_TIMEOUT,"1");
        prop.setProperty(Environment.C3P0_IDLE_TEST_PERIOD, "60000");
        prop.setProperty(Environment.USE_SECOND_LEVEL_CACHE, "true");
        prop.setProperty(Environment.USE_QUERY_CACHE,"true");
        prop.setProperty(Environment.CACHE_REGION_FACTORY,"org.hibernate.cache.ehcache.EhCacheRegionFactory"); //org.hibernate / hibernate-ehcache 필요
        return prop;
    }

    @Primary
    @Bean(name="entityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter jpsAdapter = new HibernateJpaVendorAdapter();
        jpsAdapter.setShowSql(false);
        entityManagerFactoryBean.setJpaVendorAdapter(jpsAdapter);
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(
                "com.example.toyboard.domain",
                "com.example.toyboard.dao"
        );
        entityManagerFactoryBean.setJpaProperties(jpaProperties());
        return entityManagerFactoryBean;
    }

    @Primary
    @Bean(name="jpaTransactionManager")
    public JpaTransactionManager jpaTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return transactionManager;

    }


}
