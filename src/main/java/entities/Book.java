package entities;

import java.util.Objects;

public class Book {
private String id;
private String title;

public Book() {
	super();
	// TODO Auto-generated constructor stub
}
public Book(String id, String title) {
	super();
	this.id = id;
	this.title = title;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

@Override
public String toString() {
	return "Book [id=" + id + ", title=" + title + "]";
}
@Override
public int hashCode() {
	return Objects.hash(id, title);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Book other = (Book) obj;
	return Objects.equals(id, other.id) && Objects.equals(title, other.title);
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}

}
