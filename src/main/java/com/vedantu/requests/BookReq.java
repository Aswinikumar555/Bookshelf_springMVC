package com.vedantu.requests;

import com.vedantu.enums.BookType;

public class BookReq extends AbstractFrontEndReq {
	private String Id;
	private String author;
	private String title;
	private BookType shelf;
	//private String shelf;
	private String thumbnail;
	

	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
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
	
	
	
	
	public String getThumbnail() {
		return thumbnail;
	}
	public BookType getShelf() {
		return shelf;
	}
	public void setShelf(BookType shelf) {
		this.shelf = shelf;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
	
	

}
