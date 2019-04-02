package com.vedantu.controllers;

import java.util.Collection;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vedantu.daos.AbstractSqlDAO;
import com.vedantu.daos.BookMongoDAO;
import com.vedantu.managers.BookManager;
import com.vedantu.models.BookMongo;
import com.vedantu.requests.BookReq;
import com.vedantu.utils.LogFactory;

@RestController
@RequestMapping("book")
public class BookController {
	
	@Autowired
	private LogFactory logFactory;

	@SuppressWarnings("static-access")
	private Logger logger = logFactory.getLogger(AbstractSqlDAO.class);
	@Autowired
	private BookMongoDAO bookMongoDAO;
	@Autowired
	private BookManager bookManager;
	
	//book Add
		@RequestMapping(value = "/addBook", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public String addParam(@RequestBody BookReq param) throws Exception {

			return bookManager.addBook(param);
			
		}
		
		 @RequestMapping(value = "/getBooks", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		 @ResponseBody
		 public Collection<BookMongo> getParam() throws Exception {
			 return bookManager.getAllBooks();
		 }

		
	// update Book
			@RequestMapping(value = "/updateBook", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
			@ResponseBody
			public String updateParam(@RequestBody BookReq param) throws Exception {

				return bookManager.updateBook(param);
				


			}
			
			
			// delete Book
			@RequestMapping(value = "/deleteBook", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
			@ResponseBody
			public String deleteParam(@RequestBody BookReq param) throws Exception {

				return bookManager.deleteBook(param);
		
			}
		 
		 
		@RequestMapping(value = "get", method = RequestMethod.GET)
		@ResponseBody
		public String getParamById() throws Exception {
			return "book RESPONSE";
		}

}
