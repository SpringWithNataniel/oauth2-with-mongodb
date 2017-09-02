package br.com.oauth2.mongodb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.oauth2.mongodb.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmailAndIsDeletedFalse(String email);

    User findByEmail(String email);

    Page<User> findByIsDeletedFalse(Pageable page);
    
    User findByIdAndIsDeletedFalse(String id);

}
