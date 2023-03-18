package hust.soict.dsai.aims.media;

import java.util.*;

public class Book extends Media{
    public static int nbBook = 0;
    private ArrayList<String> authors = new ArrayList<String>();

    public Book(String title, int length) {
		super(++nbBook ,title, length);
	}
	public Book(String title, String category, float cost, int length) {
		super(++nbBook, title, category, cost, length);
	}
	public Book(String title, String category, float cost) {
		super(++nbBook, title, category, cost);
	}
	public Book(String title, String category, float cost, ArrayList<String> authors, int length) {
		super(++nbBook, title, category, cost, length);
		this.authors = authors;
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
				+ " - " + this.getLength() + ": " + this.getCost() + "$";
	}
}
