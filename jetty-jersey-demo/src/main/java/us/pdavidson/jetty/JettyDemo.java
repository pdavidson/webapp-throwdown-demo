package us.pdavidson.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import us.pdavidson.throwdown.ThrowdownApp;

public class JettyDemo {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        new JettyDemo();
    }


    public JettyDemo() throws Exception {
        Server server = new Server(PORT);
        ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new ServletContainer(new ThrowdownApp())), "/*");
        server.start();

        System.out.println("Started Jetty On Port " + PORT);
        server.join();

    }
}
