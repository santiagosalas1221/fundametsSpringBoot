package com.fundaments.springboot.fundaments;

import com.fundaments.springboot.fundaments.bean.MyBean;
import com.fundaments.springboot.fundaments.bean.Operation.MyBeanWithDependence;
import com.fundaments.springboot.fundaments.bean.Operation.MyOperation;
import com.fundaments.springboot.fundaments.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentsApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependence myBeanWithDependence;
	@Autowired
	public FundamentsApplication(@Qualifier("componentSecondImpl") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependence myBeanWithDependence) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependence = myBeanWithDependence;
	}
	@Override
	public void run(String... args) throws Exception {
		componentDependency.greet();
		myBean.print();
		myBeanWithDependence.printWithDependence();
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentsApplication.class, args);
		System.out.println(">>START Fundaments of Spring Boot Project<<<");

	}
}
