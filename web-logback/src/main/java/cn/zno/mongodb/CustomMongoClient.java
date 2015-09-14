package cn.zno.mongodb;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;

public class CustomMongoClient {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private MongoClient mongoClient;
	private MongoCollection<Document> mongoCollection;

	private String uri;
	private String dbName;
	private String collectionName;

	public void init() {
		MongoClientURI mongoClientURI = new MongoClientURI(uri);
		mongoClient = new MongoClient(mongoClientURI);
		mongoCollection = mongoClient.getDatabase(dbName).getCollection(collectionName);
		logger.info("MongoClient init");
	}

	public void destroy() {
		mongoClient.close();
		logger.info("MongoClient closed");
	}

	public MongoCollection<Document> getCollection() {
		return this.mongoCollection;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
}
