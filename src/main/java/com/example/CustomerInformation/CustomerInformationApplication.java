package com.example.CustomerInformation;

import com.example.CustomerInformation.Filter.CustomerFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerInformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerInformationApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean filterUrl(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new CustomerFilter());
		filterRegistrationBean.addUrlPatterns("/api/customer/v1/getUser", "/api/customer/v1/deleteByID");

		System.out.println("You reached in main method");
		return filterRegistrationBean;
	}
}
