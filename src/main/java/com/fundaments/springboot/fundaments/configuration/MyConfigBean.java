package com.fundaments.springboot.fundaments.configuration;

import com.fundaments.springboot.fundaments.bean.MyBean;
import com.fundaments.springboot.fundaments.bean.MyBeanSecondImpl;
import com.fundaments.springboot.fundaments.bean.Operation.MyBeanWithDependence;
import com.fundaments.springboot.fundaments.bean.Operation.MyBeanWithdependenceImpl;
import com.fundaments.springboot.fundaments.bean.Operation.MyOperation;
import com.fundaments.springboot.fundaments.bean.Operation.MyOperationImpl;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyConfigBean {
    @Bean
    public MyBean myBeanOperation() {
        return new MyBeanSecondImpl();
    }

    @Bean
    public MyOperation myBeanSumOperation() {
        return new MyOperationImpl();
    }

    @Bean
    public MyBeanWithDependence myOperationWithDependence(MyOperation myOperation) {
        return new MyBeanWithdependenceImpl(myOperation);
    }

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:testdb");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
}
