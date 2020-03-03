package com.library.zipkin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.library.zipkin.entity.Book;
import com.library.zipkin.entity.BookInfo;
import com.library.zipkin.serice.BookKeepingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestEndpoint {
	

	
	@Autowired
	private BookKeepingService service;
	
	@GetMapping("/insert")
	public ResponseEntity<String> insert(){
		log.info("We are populating");
		service.dumpData();
		return ResponseEntity.ok("Done");
	}
	
	@GetMapping("/library/book/id/{id}")
	public ResponseEntity<BookInfo> getBookDetailsById(@PathVariable("id") int id){
		return ResponseEntity.ok(service.getBookById(id));
	}
	@GetMapping("/library/book/md5/{md5}")
	public ResponseEntity<String> getBookDetailsByMd5(@PathVariable("md5") String md5){
		log.info("We are populating");
		service.dumpData();
		return ResponseEntity.ok("Done");
	}
	
	@GetMapping("/library/books")
	public ResponseEntity<List<Book>> displayAll(){
		log.info("Getting all book status");
		return ResponseEntity.ok(service.getAllBooks());
	}
	

}
