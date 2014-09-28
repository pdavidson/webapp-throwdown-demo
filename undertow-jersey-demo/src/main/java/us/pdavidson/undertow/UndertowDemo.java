package us.pdavidson.undertow;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import org.glassfish.jersey.servlet.ServletContainer;

public class UndertowDemo {

    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        new UndertowDemo();
    }

    public UndertowDemo() throws Exception{
        DeploymentInfo servletBuilder = Servlets.deployment()
                .setClassLoader(UndertowDemo.class.getClassLoader())
                .setContextPath("/")
                .setDeploymentName("Undertow Throwdown")

                .addServlet(
                        Servlets.servlet("Jersey", ServletContainer.class)
                            .addInitParam("javax.ws.rs.Application", "us.pdavidson.throwdown.ThrowdownApp")
                            .addMapping("/*")
                );



        DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder);
        manager.deploy();
        PathHandler path = Handlers.path(Handlers.redirect("/"))
                .addPrefixPath("/", manager.start());

        Undertow server = Undertow.builder()
                .addHttpListener(PORT, "localhost")
                .setHandler(path)
                .build();

        System.out.println("Started Undertow On Port " + PORT);
        server.start();

    }
}
