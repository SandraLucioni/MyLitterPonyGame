package com.sandra.game.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends MongoRepository<Character, String> {
    Character findByPosition(int position);

    @Query("select max(friendshipBar) from Character")
    Character findFirstOrderByFriendshipBar();
}
