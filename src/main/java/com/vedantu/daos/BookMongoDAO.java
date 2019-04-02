package com.vedantu.daos;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.vedantu.models.BookMongo;
import com.vedantu.utils.LogFactory;

@Service
public class BookMongoDAO extends AbstractMongoDAO{


	@Autowired
    private LogFactory logFactory;

    @SuppressWarnings("static-access")
    private Logger logger = logFactory.getLogger(BookMongoDAO.class);

    @Autowired
    private MongoClientFactory mongoClientFactory;

    @Override
    protected MongoOperations getMongoOperations() {
        return mongoClientFactory.getMongoOperations();
    }

    public BookMongoDAO() {
        super();
    }

    public void create(BookMongo bookMongo) {
        try {
        	logger.info("cart "+bookMongo);
            saveEntity(bookMongo);
        } catch (Exception ex) {
            throw new RuntimeException(
                    "ContentInfoUpdateError : Error updating the content info " + bookMongo, ex);
        }
    }

    public BookMongo getById(String id) {
    	BookMongo challenge = null;
        try {
            challenge = (BookMongo) getEntityById(id, BookMongo.class);
        } catch (Exception ex) {
            throw new RuntimeException("ContentInfoFetchError : Error fetch the content info with id " + id, ex);
        }
        return challenge;
    }

    public List<BookMongo> getStudyEntryItems(List<String> cuid) {
        Query query;
        query = new Query();
        query.addCriteria(Criteria.where("cuid").in(cuid));
        return runQuery(query, BookMongo.class);
    }

    public BookMongo getStudyEntryItem(String cuid) {
        Query query = new Query();
        query.addCriteria(Criteria.where(cuid).is(cuid));
        logger.info(query);
        return findOne(query, BookMongo.class);
    }
    
    public void update(BookMongo p ,String callingUserId) {
  	  if (p != null) {
      logger.info("update: " + p.toString());
      saveEntity(p, callingUserId);
  	  }
  	  
    }
    
    public void delete(BookMongo p,String callingUserId) {
      	  if (p != null) {
          logger.info("delete: " + p.toString());
          deleteEntityById(p.getId(),BookMongo.class);
      	  }
      	  
	    }
    public List<BookMongo> getCartFromIds(Set<String> ids) {
        Query query;
        query = new Query();
        query.addCriteria(Criteria.where("id").in(ids));
        return runQuery(query, BookMongo.class);
    } 
    
    
    // get Books
    
    public Collection<BookMongo> getAll() {
       	return getAllEntities(BookMongo.class); 
       }


}