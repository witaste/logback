package cn.zno;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cn.zno.pojo.In;
import cn.zno.pojo.Out;

@Path("/hello")
public interface HelloWorld {
	@POST
	@Path("/sayhi")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	Out sayHi(In in);
}