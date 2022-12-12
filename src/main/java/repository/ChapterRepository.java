package repository;

import java.util.ArrayList;
import java.util.List;

import entities.Book;
import entities.Chapter;

public class ChapterRepository {
	static List<Chapter> list = new ArrayList<Chapter>();
	public Book book=new Book();
	public ChapterRepository() {
		// TODO Auto-generated constructor stub
		
		this.list.add(new Chapter("ref1", "JaxRS", "Web Service",3,book));
	}
	
	public List getAllChapter() {
		return this.list;
	}
	
	public String addChapter(Chapter Chapter) {
		this.list.add(Chapter);
		return "Chapter addedsuccessful";
	}
	
	public String updateChapter(Chapter i) {
		int index = getChapterById(i.getId());

		if (index != -1) {
			list.set(index, i);
			return "update successful";
		}
		return "update unsuccessful";
	}

	public String deleteChapter(String id) {
		int index = getChapterById(id);
		if (index != -1) {
			this.list.remove(index);
			return "true";
		} else
			return "false";
	}

	public int getChapterById(String id) {
		for (Chapter i : this.list) {
			if (i.getId().equals(id))
				return this.list.indexOf(i);
		}
		return -1;
	}
	
	public List<Chapter> getChapterByBook(Book book)
	{
		List<Chapter> ch=new ArrayList<Chapter>();
		for (Chapter S:list)
		{
			if (S.getBook().equals(book)) {
				ch.add(S);
				
			}
		
		}
		return ch;
		
		}


}