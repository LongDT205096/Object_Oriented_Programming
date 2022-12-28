package hust.soict.dsai.aims.media;

import java.util.*;

public class Book extends Media{
    private int length;
    private List<String> authors = new ArrayList<String>();

    public Book(String title, int length) {
		super(title);
		this.length = length;
	}
	public Book(String title, String category, float cost, int length) {
		super(title, category, cost);
		this.length = length;
	}
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	public Book(String title, String category, float cost, ArrayList<String> authors, int length) {
		super(title, category, cost);
		this.authors = authors;
		this.length = length;
	}

    public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("This author has already been in the list");
		} else {
			authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
		} else {
			System.out.println("This author is not in the list");
		}
	}

	public String toString(){
		return this.getTitle() + " - " + this.authors + " - " + this.getCategory()
				+ " - " + this.length + ": " + this.getCost() + "$";
	}
}
