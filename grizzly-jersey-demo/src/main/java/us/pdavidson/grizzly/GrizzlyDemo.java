package us.pdavidson.grizzly;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import us.pdavidson.throwdown.ThrowdownApp;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

public class GrizzlyDemo {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        new GrizzlyDemo();
    }

    public GrizzlyDemo() throws IOException {

        ThrowdownApp app = new ThrowdownApp();
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(getBaseURI(), app);

        System.out.println("Started Grizzly On Port " + PORT);
        server.start();
        System.in.read();
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(8080).build();
    }
}
