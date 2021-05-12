package com.github.erf88.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.github.erf88.model.Customer;

@Configuration
public class DelimitedFileReaderConfig {

	@StepScope
	@Bean
	public FlatFileItemReader<Customer> delimitedFileReader(
			@Value("#{jobParameters['delimited']}") Resource delimited) {
		
		return new FlatFileItemReaderBuilder<Customer>()
				.name("delimitedFileReader")
				.resource(delimited)
				.delimited()
				.names(new String[] { "name", "lastName", "age", "email" })
				.targetType(Customer.class)
				.build();
    }
	
}
