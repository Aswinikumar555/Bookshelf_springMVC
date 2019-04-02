package com.vedantu.models;

import com.vedantu.enums.BookType;

public class BookMongo  extends AbstractMongoStringIdEntity{
	private String author;
	private String title;
	//private String shelf;
	private BookType shelf;
	private String thumbnail;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
//	public String getShelf() {
//		return shelf;
//	}
//	public void setShelf(String shelf) {
//		this.shelf = shelf;
//	}
	
	
	
	
	

	public BookType getShelf() {
		return shelf;
	}
	public void setShelf(BookType shelf) {
		this.shelf = shelf;
	}
	
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
	
	

}
