package com.github.erf88.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DelimitedFileJobConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job delimitedFileJob(Step delimitedFileStep) {
		return jobBuilderFactory
				.get("delimitedFileJob")
				.start(delimitedFileStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
}
