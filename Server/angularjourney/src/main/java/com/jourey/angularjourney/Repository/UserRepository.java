package com.jourey.angularjourney.Repository;

import com.jourey.angularjourney.Entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{}