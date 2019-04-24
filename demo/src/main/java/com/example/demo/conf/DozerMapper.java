package com.example.demo.conf;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // (1)
public class DozerMapper {
	@Bean // (2)
	public Mapper beanMapper() {
		return new DozerBeanMapper(); // (3)
	}
}
