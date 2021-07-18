package org.github.throyer.common.quarkus.api.controllers;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class HomeController {

    @GET
    public Map<String, Object> index() {
        return Map.of("message", "Is a live!");
    }
}