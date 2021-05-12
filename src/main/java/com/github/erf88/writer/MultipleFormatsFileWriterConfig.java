package com.github.erf88.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipleFormatsFileWriterConfig {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ItemWriter multipleFormatsFileWriter() {
		return items -> items.forEach(System.out::println);
	}

}
