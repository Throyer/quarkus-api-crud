package com.github.throyer.common.quarkus.api.controllers;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.throyer.common.quarkus.api.domain.repositories.UserRepository;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersController {
    
    @Inject
    UserRepository repository;

    @GET
    public Response index() {
        return Response.ok(repository.listAll()).build();
    }
}
