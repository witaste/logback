import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxrs.client.WebClient;

import cn.zno.pojo.In;
import cn.zno.pojo.Out;


public class Test {
	
	@org.junit.Test
	public void tt(){
		List<Object> providers = new ArrayList<Object>();
		providers.add(new org.codehaus.jackson.jaxrs.JacksonJsonProvider());

		In in = new In();
		in.setMsg("INFO1");
		WebClient client = WebClient.create(
				"http://localhost:8080/web-logback/hello/sayhi",
				providers);
		Out out = client.accept("application/json")
				.type("application/json").post(in, Out.class);
		System.out.println(out.getMsg());
	}
}
