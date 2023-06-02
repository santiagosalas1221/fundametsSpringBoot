package com.fundaments.springboot.fundaments;

import com.fundaments.springboot.fundaments.bean.MyBean;
import com.fundaments.springboot.fundaments.bean.Operation.MyBeanWithDependence;
import com.fundaments.springboot.fundaments.bean.Operation.MyOperation;
import com.fundaments.springboot.fundaments.component.ComponentDependency;
import com.fundaments.springboot.fundaments.entity.User;
import com.fundaments.springboot.fundaments.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentsApplication implements CommandLineRunner {

	static Log LOGGER = LogFactory.getLog(FundamentsApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependence myBeanWithDependence;
	private UserRepository userRepository;
	@Autowired
	public FundamentsApplication(@Qualifier("componentSecondImpl") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependence myBeanWithDependence, UserRepository userRepository) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependence = myBeanWithDependence;
		this.userRepository = userRepository;
	}
	@Override
	public void run(String... args) throws Exception {
		componentDependency.greet();
		myBean.print();
		myBeanWithDependence.printWithDependence();
	//	pastExamples();
		saveUsersIndataBase();
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentsApplication.class, args);

	}

	private void saveUsersIndataBase() {
		User user1 = new User("Santiago", "santiago@gmail.com", LocalDate.of(2021,03,20));
		User user2 = new User("Julie", "sjulie@gmail.com", LocalDate.of(2023,05,31));
		List<User> list = Arrays.asList(user1, user2);
		userRepository.saveAll(list);
	}


	private void pastExamples() {
		System.out.println(">>START Fundaments of Spring Boot Project<<<");
		LOGGER.error("Log error de ejemplo en aplicacion");

		try {
			//Error
		} catch (Exception exception) {
			LOGGER.error("Log error de ejemplo en aplicacion");
		}
	}
}
