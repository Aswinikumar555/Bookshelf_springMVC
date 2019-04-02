package com.vedantu.managers;

import java.util.Collection;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.vedantu.daos.AbstractMongoDAO;
import com.vedantu.daos.AbstractSqlDAO;
import com.vedantu.daos.BookMongoDAO;
import com.vedantu.models.BookMongo;
import com.vedantu.models.OrderMongo;
import com.vedantu.requests.BookReq;
import com.vedantu.utils.LogFactory;

@Service
public class BookManager extends AbstractMongoDAO {
	
	
	@Autowired
	private LogFactory logFactory;

	@SuppressWarnings("static-access")
	private Logger logger = logFactory.getLogger(AbstractSqlDAO.class);
	
	@Autowired
	private BookMongoDAO bookMongoDAO;
	
	public String addBook(BookReq bookReq) throws Exception{
		BookMongo e2 = new BookMongo();
		
		e2.setAuthor(bookReq.getAuthor());
		e2.setTitle(bookReq.getTitle());
		e2.setShelf(bookReq.getShelf()); 
		e2.setThumbnail(bookReq.getThumbnail());
		
		if(e2.getAuthor().isEmpty()) {
			return "Author is Empty";
		}
		if(e2.getTitle().isEmpty()) {
			return "Title is Empty";
		}
		if(e2.getShelf() == null) {
			return "Shelf is Empty";
		}
		if(e2.getThumbnail().isEmpty()) {
			return "Thumbnail is Empty";
		}
		if(!e2.getAuthor().isEmpty() && !e2.getTitle().isEmpty() && e2.getShelf() != null && !e2.getThumbnail().isEmpty()) {
			logger.info("not null");
			bookMongoDAO.create(e2);
			return "Book added succfully";
		}
		else {
			logger.info("null");
			return "Fill all details";
			
		}
		
	}
	
	public String updateBook(BookReq bookReq) throws Exception{
		BookMongo update_obj = bookMongoDAO.getById(bookReq.getId());
		if(update_obj == null) {
				return "Book Id is Not Matching";
		}
		update_obj.setThumbnail(bookReq.getThumbnail());
		update_obj.setAuthor(bookReq.getAuthor());
		update_obj.setTitle(bookReq.getTitle());
		update_obj.setShelf(bookReq.getShelf());
		update_obj.setThumbnail(bookReq.getThumbnail());
		
		if(update_obj.getAuthor().isEmpty()) {
			return "Author is Empty";
		}
		if(update_obj.getTitle().isEmpty()) {
			return "Title is Empty";
		}
		if(update_obj.getShelf() == null) {
			return "Shelf is Empty";
		}
		if(update_obj.getThumbnail().isEmpty()) {
			return "Thumbnail is Empty";
		}
		
		if(!update_obj.getAuthor().isEmpty() && !update_obj.getTitle().isEmpty() && update_obj.getShelf() != null && !update_obj.getThumbnail().isEmpty()) {
			logger.info("not null");
			bookMongoDAO.update(update_obj, null);
			return "update success";
			
		}
		else {
			return "update Failed";
			
		}
		
	}
	
	public String deleteBook(BookReq bookReq) throws Exception{
		BookMongo e2 = bookMongoDAO.getById(bookReq.getId());
		if(e2 == null) {
			return "Book Id Not Match";
		}

		bookMongoDAO.delete(e2, null);

		return "Delete Success";
	}
	
	public Collection<BookMongo> getAllBooks() throws Exception {
		Collection<BookMongo> books_Data = bookMongoDAO.getAll();
		 return books_Data;
	}

	@Override
	protected MongoOperations getMongoOperations() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
