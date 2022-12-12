package grapheql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import entities.Book;
import entities.Chapter;
import repository.BookRepository;
import repository.ChapterRepository;

public class Mutation implements GraphQLRootResolver {
	private final BookRepository bookRepository ;
	private final ChapterRepository chapterRepository ;
	 
	public Mutation(BookRepository stdB,ChapterRepository stdC)
	{
		this.bookRepository=stdB;
		this.chapterRepository=stdC;
	}
	
	public String addBook(Book book) {
		return this.bookRepository.addBook(book);
	}
	public String updateBook(Book i) {
		return this.bookRepository.updateBook(i);
	}
	public String deleteBook(String id) {
		return this.deleteBook(id);
	}
	public String addChapter(Chapter Chapter) {
		return this.chapterRepository.addChapter(Chapter);
	}
	public String updateChapter(Chapter i) {
		return this.chapterRepository.updateChapter(i);
	}
	public String deleteChapter(String id) {
		return this.chapterRepository.deleteChapter(id);
	}

}
