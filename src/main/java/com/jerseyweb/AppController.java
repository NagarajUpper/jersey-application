package com.jerseyweb;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import com.jerseyweb.ServiceImpl.CustomersServiceImpl;
import com.jerseyweb.model.Customer;

@Path("Customer")
public class AppController {

	CustomersServiceImpl impl = new CustomersServiceImpl();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getCust(@Context UriInfo info,@QueryParam("id") String id) {
		
		
		//@BeamParam, @Param, @PathParam,
		
		MultivaluedMap<String, String> queryParameters = info.getQueryParameters();

		 queryParameters.forEach((i,j)->System.out.println("Key: "+ i+"value: "+j));
		List<Customer> gecust = impl.gecust();
		return gecust;
	}

}
