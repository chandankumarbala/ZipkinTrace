package com.dealer.zipkin.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class Book {
    private String id;
	private String md5;
	private String title;
	private String volumeinfo;
	private String author;
	private String publisher;
	private String language;
	private String googlebookid;
	private String coverurl;
}
