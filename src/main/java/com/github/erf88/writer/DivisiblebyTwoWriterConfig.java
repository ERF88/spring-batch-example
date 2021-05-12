package com.github.erf88.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DivisiblebyTwoWriterConfig {

	@Bean
	public ItemWriter<String> divisiblebyTwoWriter() {		
		return items -> items.forEach(System.out::println);
	}
	
}
