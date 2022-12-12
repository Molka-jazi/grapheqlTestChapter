package entities;

import java.util.Objects;

public class Chapter {
	private String id;
	private String name;
	private String course;
	private int  order;
	private Book book;
	public Chapter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Chapter(String id, String name, String course, int order,Book book) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.order = order;
		this.book=book;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Chapter [id=" + id + ", name=" + name + ", course=" + course + ", order=" + order + ", book=" + book
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(book, course, id, name, order);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chapter other = (Chapter) obj;
		return Objects.equals(book, other.book) && Objects.equals(course, other.course) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && order == other.order;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
}
