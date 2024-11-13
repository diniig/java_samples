package org.diniig.samples;

import org.diniig.samples.services.ManagedExecutor1;
import org.diniig.samples.services.ManagedExecutor2;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    ManagedExecutor1 managedExecutor1;
    @Inject
    ManagedExecutor2 managedExecutor2;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        managedExecutor1.runProcess();
        managedExecutor2.runProcess();

        return "Hello RESTEasy";
    }
}
