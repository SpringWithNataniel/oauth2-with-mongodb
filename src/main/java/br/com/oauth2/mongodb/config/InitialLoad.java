package br.com.oauth2.mongodb.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import br.com.oauth2.mongodb.entity.Role;
import br.com.oauth2.mongodb.entity.User;
import br.com.oauth2.mongodb.repository.RoleRepository;
import br.com.oauth2.mongodb.repository.UserRepository;

/**
 *
 * @author Nataniel Paiva
 */
@Component
public class InitialLoad implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {

        List<Role> roles = roleRepository.findAll();

        if (roles.isEmpty()) {
            roleRepository.save(new Role("ROLE_ADMIN", "Admin", Boolean.FALSE));
            roleRepository.save(new Role("ROLE_USER", "User", Boolean.FALSE));

            Role role = roleRepository.findByName("ROLE_ADMIN");

            List<Role> rolesNew = new ArrayList<>();

            rolesNew.add(role);

            userRepository.save(new User("Admin", "admin", "123", rolesNew));

        }

    }

}
