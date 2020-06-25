package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repo.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repo;
	List <Book> list = new ArrayList<Book>();
	
	public List<Book> allBooks(){
		
		//System.out.println(repo.findAll());
		return repo.findAll();
	}
	
	public Book get(Integer id) {
		return repo.findById(id).get();
		
	}
	public void save(Book book) {
		repo.save(book);
	}
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	public Optional<Book> findId(Integer id) {
		return repo.findById(id);
	}

}
