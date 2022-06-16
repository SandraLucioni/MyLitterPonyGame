package com.sandra.game.repositories;

import com.sandra.game.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findByEmailAndPassword(String email, String password);
    User findByNameAndPassword(String username, String password);
}
