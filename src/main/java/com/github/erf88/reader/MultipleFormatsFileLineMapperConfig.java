package com.github.erf88.reader;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.erf88.model.Customer;
import com.github.erf88.model.Transaction;

@Configuration
@SuppressWarnings({ "unchecked", "rawtypes" })
public class MultipleFormatsFileLineMapperConfig {

	@Bean
	public PatternMatchingCompositeLineMapper lineMapper() {
		PatternMatchingCompositeLineMapper lineMapper = new PatternMatchingCompositeLineMapper<>();
		lineMapper.setTokenizers(tokenizers());
		lineMapper.setFieldSetMappers(fieldSetMappers());
		return lineMapper;
	}

	private Map<String, LineTokenizer> tokenizers() {
		Map<String, LineTokenizer> tokenizers = new HashMap<>();
		tokenizers.put("0*", customerLineTokenizer());
		tokenizers.put("1*", transactionLineTokenizer());
		return tokenizers;
	}

	private LineTokenizer customerLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("name", "lastName", "age", "email");
		lineTokenizer.setIncludedFields(1, 2, 3, 4);
		return lineTokenizer;
	}

	private LineTokenizer transactionLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("id", "description", "value");
		lineTokenizer.setIncludedFields(1, 2, 3);
		return lineTokenizer;
	}

	private Map fieldSetMappers() {		
		Map<String, FieldSetMapper> fieldSetMappers = new HashMap<>();
		fieldSetMappers.put("0*", fieldSetMapper(Customer.class));
		fieldSetMappers.put("1*", fieldSetMapper(Transaction.class));
		return fieldSetMappers;
	}
	
	private FieldSetMapper fieldSetMapper(Class clazz) {
		BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(clazz);
		return fieldSetMapper;
	}
}
