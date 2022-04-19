package com.corso.java.jfirstaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class MyResourceService {
    @GET
    @Path("{name : [a-zA-Z]+}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getMsg(@PathParam("name") String name){
        String out = "Hello " + name;
        return Response
                .status(200)
                .entity(out)
                .build();
    }
}
