package registerservice;

import java.io.IOException;

import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;

public class CorsResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(javax.ws.rs.container.ContainerRequestContext requestContext, javax.ws.rs.container.ContainerResponseContext responseContext) throws IOException {
		MultivaluedMap<String, Object> headers = responseContext.getHeaders();
		 
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");			
		headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia");
    }
}
