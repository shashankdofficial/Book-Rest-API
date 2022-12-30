package com.api.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

//	private static List<Book> list = new ArrayList<>();
//	
//	static {
//		list.add(new Book(1,"Java Complete Reference","Shashank"));
//		list.add(new Book(2,"Python Complete Reference","Rohit"));
//		list.add(new Book(3,"JavaScript Complete Reference","Shanky"));
//	}
	
	//get all Books
	public List<Book> getAllBooks(){
		List<Book> list = (List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	//get single book by id
	public Book getBookById(int id) {
		Book book = null;
		try {
//			book = list.stream().filter(e->e.getId()==id).findFirst().get();
			book = this.bookRepository.findById(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return book;
		
	}
	
	//Adding the book
	public Book addBook(Book b) {
		Book result = bookRepository.save(b);
		return result;
	}
	
	//delete Book
	public void deleteBook(int bid) {
//		list.stream().filter(book->{
//			if(book.getId()!=bid) {
//				return true;
//			}
//			else {
//				return false;
//			}
//		}).collect(Collectors.toList());
		
//		list = list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
		
		bookRepository.deleteById(bid);
	}
	
	//Update Book
	public void updateBook(Book book, int bookId) {
//		list = list.stream().map(b->{
//			if(b.getId()==bookId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
		book.setId(bookId);
		bookRepository.save(book);
	}
}
