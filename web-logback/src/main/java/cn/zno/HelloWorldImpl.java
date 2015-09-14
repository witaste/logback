package cn.zno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.zno.mongodb.CustomMongoClient;
import cn.zno.pojo.In;
import cn.zno.pojo.Out;

public class HelloWorldImpl implements HelloWorld {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private CustomMongoClient customMongoClient;

	@Override
	public Out sayHi(In in) {
		logger.error("这是一个错误！");
		Out out = new Out();
		out.setMsg("Hello " + in.getMsg());
		return out;
	}
}