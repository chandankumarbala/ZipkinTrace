package com.library.zipkin.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.library.zipkin.entity.Book;


@Repository
public interface BookRepository   extends ElasticsearchRepository<Book, Long> { 

	List<Book> findByMd5(String md5);
}
