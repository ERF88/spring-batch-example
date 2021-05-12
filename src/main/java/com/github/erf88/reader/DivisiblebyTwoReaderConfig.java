package com.github.erf88.reader;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DivisiblebyTwoReaderConfig {

	@Bean
	public IteratorItemReader<Integer> divisiblebyTwoReader() {	
		List<Integer> numbers = IntStream.range(1, 11).boxed().collect(Collectors.toList());
		return new IteratorItemReader<Integer>(numbers.iterator());
	}
	
}
