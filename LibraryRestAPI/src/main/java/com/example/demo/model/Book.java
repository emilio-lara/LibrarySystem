package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {
	@Id
	@Column(name="id")
	private Integer id;
	@Column(name="State")
	private String state;
	@Column(name="Title")
	private String title;
	@Column(name="Author")
	private String author;
	@Column(name="Year")
	private Integer year;
	@Column(name="Shell")
	private Integer shell;
	
	public Book() {
	}
	public Book(Integer id, String state, String title, String author, Integer year, Integer shell) {
		super();
		this.id = id;
		this.state = state;
		this.title = title;
		this.author = author;
		this.year = year;
		this.shell = shell;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", state=" + state + ", title=" + title + ", author=" + author + ", year=" + year
				+ ", shell=" + shell + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getShell() {
		return shell;
	}
	public void setShell(Integer shell) {
		this.shell = shell;
	}
	
	 

}
