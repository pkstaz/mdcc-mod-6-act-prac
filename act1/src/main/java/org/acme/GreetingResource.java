package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

@Path("/greeting")
public class GreetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        
        return "Message: Hello RESTEasy";
    }

    @GET
    @Path("bienvenida/json/{p}")
    @Produces({MediaType.APPLICATION_JSON})
    public HolaMundo saludoJsonP(@PathParam("p") String id){
        HolaMundo hm = new HolaMundo();
        hm.setSaludo("Hola JSON: " + id);

        return hm;
    }

    @GET
    @Path("/health")
    @Produces(MediaType.APPLICATION_JSON)
    public String healthCheck(){
        return "I'm Ok! :D";
    }
}

