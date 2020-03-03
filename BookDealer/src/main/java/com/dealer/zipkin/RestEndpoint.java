package com.dealer.zipkin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dealer.zipkin.entity.Book;
import com.dealer.zipkin.serice.BookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestEndpoint {
	
	@Autowired
	private BookService service;
	
	
	@GetMapping("/dealer/id/{id}")
	public ResponseEntity<Book> getBookDetailsById(@PathVariable("id") int id){
		return ResponseEntity.ok(service.getBookById(String.valueOf(id)));
	}
	@GetMapping("/dealer/md5/{md5}")
	public ResponseEntity<Book> getBookDetailsByMd5(@PathVariable("md5") String md5){
		return ResponseEntity.ok(service.getBookById(md5));
	}
	
}
