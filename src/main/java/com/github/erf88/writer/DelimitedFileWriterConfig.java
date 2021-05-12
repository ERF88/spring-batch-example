package com.github.erf88.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.erf88.model.Customer;

@Configuration
public class DelimitedFileWriterConfig {
	
	@Bean
	public ItemWriter<Customer> delimitedFileWriter() {
		return items -> items.forEach(System.out::println);
	}

}
