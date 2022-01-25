package com.abdulbasit.spring.documented.webapp.Repository;

import com.abdulbasit.spring.documented.webapp.Model.UserData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveMongoRepository<UserData, String> {

}
