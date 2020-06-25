package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService service;
	
	@GetMapping("/books")
	public List<Book> findBooks() {
		
		return service.allBooks();
	}
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> get(@PathVariable Integer id){
		
		try {
			Book book = service.get(id);
			return new ResponseEntity<Book>(book,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/books")
	public String add(@RequestBody Book book) {
		service.save(book);
		return "Book was added";
	}
	
	@DeleteMapping("/books/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "Book "+id+"was deleted";
		
	}
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> update(@RequestBody Book book, @PathVariable Integer id){
		Optional<Book> bookOptional = service.findId(id);
		
		if(!bookOptional.isPresent())
			return ResponseEntity.notFound().build();
		book.setId(id);
		service.save(book);
		return ResponseEntity.noContent().build();
		
		
	}

}
