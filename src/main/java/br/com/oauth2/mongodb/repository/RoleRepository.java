package br.com.oauth2.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.oauth2.mongodb.entity.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

    /**
     *
     * @param name
     * @return
     */
    Role findByName(String name);
}
