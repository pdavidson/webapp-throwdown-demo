package us.pdavidson.throwdown;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
public class ThrowdownApp extends ResourceConfig{
    public ThrowdownApp(){
        packages("us.pdavidson.throwdown.resource");
    }
}

