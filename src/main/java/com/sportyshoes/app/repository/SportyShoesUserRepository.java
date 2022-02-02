package com.sportyshoes.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.sportyshoes.app.model.User;

public interface SportyShoesUserRepository extends CrudRepository<User, String> {

}
