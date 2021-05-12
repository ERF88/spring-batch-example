package com.github.erf88.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Transaction {

	public String id;
	public String description;
	public Double value;
	
}
