package repository;

import java.util.ArrayList;
import java.util.List;

import entities.Book;

public class BookRepository {
	static List<Book> list = new ArrayList<Book>();
	public BookRepository() {
		// TODO Auto-generated constructor stub
		
		this.list.add(new Book("123", "123"));
	}
	
	public List getAllBook() {
		return this.list;
	}
	
	public String addBook(Book book) {
		this.list.add(book);
		return "book added successful";
	}
	
	public String updateBook(Book i) {
		int index = getBookById(i.getId());

		if (index != -1) {
			list.set(index, i);
			return "update successful";
		}
		return "update unsuccessful";
	}

	public String deleteBook(String id) {
		int index = getBookById(id);
		if (index != -1) {
			this.list.remove(index);
			return "true";
		} else
			return "false";
	}

	public int getBookById(String id) {
		for (Book i : this.list) {
			if (i.getId().equals(id))
				return this.list.indexOf(i);
		}
		return -1;
	}

}
