package com.ecommerce.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ecommerce.model.Book;

//@Repository
//public interface BookRepository extends JpaRepository<Book, Integer> {
//}

@Component
public class BookRepository {

	public static List<Book> books = new  ArrayList<>(); 
	static {
		books.add(new Book(1,"Java","Malli"));
		books.add(new Book(2,"Oracle","ramesh"));
		books.add(new Book(3,"Photn","siva"));
	}
	public List<Book> findAll() {
		return books;
	}

	public Optional<Book> findById(int id) {
		return  books.stream().filter(e -> e.getId() == id).findAny();
	}
	
	
	
}