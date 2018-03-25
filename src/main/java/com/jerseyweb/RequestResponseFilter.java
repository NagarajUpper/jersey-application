package com.jerseyweb;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class RequestResponseFilter implements ContainerRequestFilter, ContainerResponseFilter {

	private String auth = "Authorization";

	@Override
	public void filter(ContainerRequestContext rc, ContainerResponseContext rs) throws IOException {
		rs.getHeaders().add("myheader", "TestHeader");

		System.out.println("Response Header" + rs);
	}

	@Override
	public void filter(ContainerRequestContext rc) throws IOException {

		if(null !=rc.getHeaders().get(auth)) {
		List<String> list = rc.getHeaders().get(auth);
		if (list.size() > 0) {
			String string = list.get(0);
			String oth = string.replace("Basic", "");
			String decodeAsString = Base64.decodeAsString(oth);
			StringTokenizer tokenizer = new StringTokenizer(decodeAsString,":");
			String user = tokenizer.nextToken();
			String pwd = tokenizer.nextToken();

			if (user.equals("user") && pwd.equals("pwd")) {

				return;

			}
		}

			Response response = Response.status(Response.Status.UNAUTHORIZED).entity("UnAuthorized").build();

			rc.abortWith(response);
			
		}

		System.out.println("Request Header+ " + rc.toString());

	}

}
