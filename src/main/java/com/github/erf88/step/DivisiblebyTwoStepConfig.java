package com.github.erf88.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DivisiblebyTwoStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step divisiblebyTwoStep(
			IteratorItemReader<Integer> divisiblebyTwoReader,
			FunctionItemProcessor<Integer,String> divisiblebyTwoProcessor,
			ItemWriter<String> divisiblebyTwoWriter) {

		return stepBuilderFactory
				.get("divisiblebyTwoStep")
				.<Integer, String>chunk(10)
				.reader(divisiblebyTwoReader)
				.processor(divisiblebyTwoProcessor)
				.writer(divisiblebyTwoWriter)
				.build();
		
	}
	
}
