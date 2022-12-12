package grapheql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import entities.Book;
import entities.Chapter;
import repository.BookRepository;
import repository.ChapterRepository;

public class Query implements GraphQLRootResolver {
	private final BookRepository bookRepository ;
	private final ChapterRepository chapterRepository ;
	
	public Query(BookRepository stdB,ChapterRepository stdC)
	{
		this.bookRepository=stdB;
		this.chapterRepository=stdC;
	}
	
	public List<Book> getAllBook() {
		return bookRepository.getAllBook();
	}
    public int getBookById(String id) {
    	return bookRepository.getBookById(id);
    }
    
	public List<Chapter> getAllChapter() {
		return chapterRepository.getAllChapter();
	}
	
	public int getChapterById(String id) {
		return chapterRepository.getChapterById(id);
	}

}
