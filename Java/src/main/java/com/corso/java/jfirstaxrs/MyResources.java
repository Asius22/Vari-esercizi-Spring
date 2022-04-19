package com.corso.java.jfirstaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("myresources")
public class MyResources {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(){
        return "{\"\": \"got it\"}";
    }
}
