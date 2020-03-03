package com.library.zipkin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookInfo {
	
	private BookContentDetails contentDetails;
	private Book availibility;

}
