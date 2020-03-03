package com.library.zipkin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookContentDetails {
	
	@JsonIgnore
    private String id;
	
	@JsonIgnore
	private String md5;
	
	
	private String title;
	private String volumeinfo;
	private String author;
	private String publisher;
	private String language;
	private String googlebookid;
	private String coverurl;
	
}
