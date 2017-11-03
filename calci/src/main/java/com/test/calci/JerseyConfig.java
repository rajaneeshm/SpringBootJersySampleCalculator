package com.test.calci;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {
 
  @Autowired
  public JerseyConfig(ObjectMapper objectMapper) {
    packages("com.test.calci.endpoint");
    register(new ObjectMapperContextResolver(objectMapper));
    register(new UncaughtException());
  }
  
  
	
  
  @Provider
  public class UncaughtException extends Throwable implements ExceptionMapper<Throwable>
  {
      private static final long serialVersionUID = 1L;
      private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
      @Override
      public Response toResponse(Throwable exception)
      {
    	  logger.info(exception.getMessage());
          return Response.status(500).entity(exception.getMessage()+ " \n only numbers are allowed as paramaters \n Something bad happened. Please try again !!").build();
      }
  }
 
  @Provider
  public static class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {
 
    private final ObjectMapper mapper;
 
    public ObjectMapperContextResolver(ObjectMapper mapper) {
      this.mapper = mapper;
    }
 
    @Override
    public ObjectMapper getContext(Class<?> type) {
      return mapper;
    }
  }
}