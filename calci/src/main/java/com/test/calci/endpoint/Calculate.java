package com.test.calci.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.calci.model.Math;
import com.test.calci.service.MathService;

@Component
@Path("/")
public class Calculate {

	@Autowired
	private MathService mathService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GET
	@Path("/add/{a:([0-9.]*)}/{b:([0-9.]*)}{p:/?}{c:([0-9.]*)}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response addition(@PathParam("a") double a, @PathParam("b") double b, @PathParam("c") String c) {
		logger.info("In controller addition :  a:"+a+" b:"+b+" c:"+c);
		Math math = null;
		if(c == null || c.isEmpty()){
			math = new Math(a, b, 0.0, "Addition");
		}else{
			 math = new Math(a, b, Double.valueOf(c), "Addition");
		}
		
		math = mathService.add(math);
		return Response.status(201).entity(math).build();
	}
	
	@GET
	@Path("/subtract/{a:([0-9.]*)}/{b:([0-9.]*)}{p:/?}{c:([0-9.]*)}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response subtract(@PathParam("a") double a, @PathParam("b") double b, @PathParam("c") String c) {
		logger.info("In controller Substraction :  a:"+a+" b:"+b+" c:"+c);
		Math math = null;
		if(c == null || c.isEmpty()){
			math = new Math(a, b, 0.0, "Substraction");
		}else{
			 math = new Math(a, b, Double.valueOf(c), "Substraction");
		}
		math = mathService.subtract(math);
		return Response.status(201).entity(math).build();
	}
	
	@GET
	@Path("/multiply/{a:([0-9.]*)}/{b:([0-9.]*)}{p:/?}{c:([0-9.]*)}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response multiply(@PathParam("a") double a, @PathParam("b") double b, @PathParam("c") String c) {
		logger.info("In controller Multiplication :  a:"+a+" b:"+b+" c:"+c);
		Math math = null;
		if(c == null || c.isEmpty()){
			math = new Math(a, b,1.0, "Multiplication");
		}else{
			 math = new Math(a, b, Double.valueOf(c), "Multiplication");
		}
		math = mathService.multiply(math);
		return Response.status(201).entity(math).build();
	}
	
	
	@GET
	@Path("/divide/{a:([0-9.]*)}/{b:([0-9.]*)}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response divide(@PathParam("a") double a, @PathParam("b") double b) {
		logger.info("In controller Division :  a:"+a+" b:"+b);
		Math math = new Math(a, b,  "Division");
		math = mathService.divide(math);
		return Response.status(201).entity(math).build();
	}
	
}