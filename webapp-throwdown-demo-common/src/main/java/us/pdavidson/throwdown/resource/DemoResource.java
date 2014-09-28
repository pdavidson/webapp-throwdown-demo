package us.pdavidson.throwdown.resource;

import com.google.common.collect.Iterables;
import us.pdavidson.throwdown.DemoBean;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Set;
import java.util.TreeSet;

@Path("/")
@Singleton
@Produces("application/json")
public class DemoResource {

        private static final Integer NumberOfNodes = 1000000;
        private Set<DemoBean> dataSource;

        public DemoResource() {
            dataSource = new TreeSet<>();

            for (int i = 0 ; i < NumberOfNodes ; i++) {
                dataSource.add(new DemoBean(String.valueOf(i)));
            }
        }

        @GET
        @Path("{name}")
        public Response hello(@PathParam("name")String name){
            DemoBean demoBean = Iterables.tryFind(dataSource, demo -> name.equals(demo.getName())).orNull();
            if (demoBean == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            return Response.ok(demoBean).build();
        }
    }


