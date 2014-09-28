package us.pdavidson.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class JettyDemo {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        new JettyDemo();
    }


    public JettyDemo() throws Exception {
        ServletHolder sh = new ServletHolder(ServletContainer.class);

        sh.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "us.pdavidson.jetty.JettyDemo");
//        sh.setInitParameter("com.sun.jersey.config.property.packages", "rest");//Set the package where the services reside


        Server server = new Server(PORT);
        ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.NO_SESSIONS);
        context.addServlet(sh, "/*");
        server.start();

        System.out.println("Started Jetty On Port " + PORT);
        server.join();

    }
}
