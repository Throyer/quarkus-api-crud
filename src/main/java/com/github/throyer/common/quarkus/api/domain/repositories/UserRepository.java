package com.github.throyer.common.quarkus.api.domain.repositories;

import javax.enterprise.context.ApplicationScoped;

import com.github.throyer.common.quarkus.api.domain.models.entity.User;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> { }
