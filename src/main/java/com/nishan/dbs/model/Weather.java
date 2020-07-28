package com.nishan.dbs.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Document(collection = "weather")
public class Weather {
	
	@Id
	private String city;
	private String temp;
	private Date createdOn;

}
