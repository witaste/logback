package cn.zno.mongodb;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.bson.Document;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;

public class MongoDBAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {

	public static final String UNKNOW_HOST = "unknow host";

	private CustomMongoClient mongoClient;

	@Override
	protected void append(ILoggingEvent eventObject) {
		if (mongoClient.getCollection() == null) {
			mongoClient.init();
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
				public void run() {
					mongoClient.destroy();
				}
			}, "mongo shutdown"));
		}

		Document document = new Document();
		document.append("message", eventObject.getFormattedMessage());
		document.append("logger", eventObject.getLoggerName());
		document.append("thread", eventObject.getThreadName());
		document.append("timestamp", new Date(eventObject.getTimeStamp()));
		document.append("level", eventObject.getLevel().toString());
		document.append("pid", getPid());
		document.append("ip", getIp());

		mongoClient.getCollection().insertOne(document);
	}

	private String getIp() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return UNKNOW_HOST;
		}
	}

	private String getPid() {
		return ManagementFactory.getRuntimeMXBean().getName();
	}

	public CustomMongoClient getMongoClient() {
		return mongoClient;
	}

	public void setMongoClient(CustomMongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}
}
