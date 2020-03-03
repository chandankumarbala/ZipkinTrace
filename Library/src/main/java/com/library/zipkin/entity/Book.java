package com.library.zipkin.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Getter;
import lombok.Setter;

@Document(indexName = "bookindex", type = "book")
@Getter
@Setter
public class Book {

	@Id
    private Long id;
	private String md5;
	private int totalCopies;
	private int availableCopies;
}
