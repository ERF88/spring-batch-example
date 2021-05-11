package com.github.erf88.config;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class DivisiblebyTwoConfig {
	

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job divisiblebyTwoJob() {

		return jobBuilderFactory
				.get("divisiblebyTwoJob")
				.start(divisiblebyTwoStep())
				.incrementer(new RunIdIncrementer())
				.build();

	}

	private Step divisiblebyTwoStep() {

		return stepBuilderFactory
				.get("divisiblebyTwoStep")
				.<Integer, String>chunk(1)
				.reader(countUntilTen())
				.processor(divisiblebyTwoProcessor())
				.writer(printWriter())
				.build();
		
	}

	public IteratorItemReader<Integer> countUntilTen() {	
		List<Integer> numbers = IntStream.range(1, 11).boxed().collect(Collectors.toList());
		return new IteratorItemReader<Integer>(numbers.iterator());
	}

	public FunctionItemProcessor<Integer,String> divisiblebyTwoProcessor() {		
		return new FunctionItemProcessor<Integer, String>
		(item -> item % 2 == 0 ? String.format("Number %s is divisible by two", item) : String.format("Number %s is not divisible by two", item));
	}
	
	public ItemWriter<String> printWriter() {		
		return items -> items.forEach(System.out::println);
	}
}
