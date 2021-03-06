package com.github.erf88.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipleFormatsFileStepConfig {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public Step multipleFormatsFileStep(
			FlatFileItemReader multipleFormatsFileReader,
			ItemWriter multipleFormatsFileWriter) {
		return stepBuilderFactory
				.get("multipleFormatsFileStep")
				.chunk(1)
				.reader(multipleFormatsFileReader)
				.writer(multipleFormatsFileWriter)
				.build();
	}
	
}
