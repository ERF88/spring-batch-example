package com.github.erf88.processor;

import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DivisiblebyTwoProcessorConfig {

	@Bean
	public FunctionItemProcessor<Integer,String> divisiblebyTwoProcessor() {		
		return new FunctionItemProcessor<Integer, String>
		(item -> item % 2 == 0 ? String.format("Number %s is divisible by two", item) : String.format("Number %s is not divisible by two", item));
	}
	
}
