package cn.zno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

	public static void main(String[] args) {
		TestLogback tl = new TestLogback();
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				System.out.println("bbbbb");
			}
		}, "bb thread"));
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				System.out.println("cc");
			}
		}, "cc thread"));
		tl.printLog();
		
	}

}

class TestLogback {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public void printLog() {
		// logger.trace("It is trace");
		// logger.debug("It is debug");
		// logger.info("It is info");
		// logger.warn("It is warn");
		// logger.error("It is error");
		int a = 1 / 0;

	}

}
