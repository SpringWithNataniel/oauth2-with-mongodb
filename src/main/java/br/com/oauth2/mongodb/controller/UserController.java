package br.com.oauth2.mongodb.controller;



import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.oauth2.mongodb.entity.User;
import br.com.oauth2.mongodb.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;

//    @Autowired
//    UserService service;


    @RequestMapping(value = "/public/user/{page}/{count}", method = RequestMethod.GET)
    public Page<User> list(@PathVariable int page, @PathVariable int count) {

        Pageable pages = new PageRequest(page, count);

        Page<User> list = repository.findByIsDeletedFalse(pages);
        return list;
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public User currentUserName(Principal principal) {
        User usuario = this.repository.findByEmailAndIsDeletedFalse(principal.getName());
        usuario.setPass("");
        return usuario;
    }

    @RequestMapping(value = "/user-data", method = RequestMethod.GET)
    @ResponseBody
    public User currentUserData(Principal principal) {
        User usuario = this.repository.findByEmailAndIsDeletedFalse(principal.getName());
        usuario.setPass("");
        return usuario;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User save(@RequestBody User user) {
        user.setIsDeleted(Boolean.FALSE);
        return repository.save(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public User update(@RequestBody User user) {
        return repository.save(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getById(@PathVariable String id) {
        return repository.findByIdAndIsDeletedFalse(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        User user = getById(id);
        user.setIsDeleted(Boolean.TRUE);
        repository.save(user);
    }

   

}