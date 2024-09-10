package dio.dio.spring.security.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.dio.spring.security.jwt.model.User;
import dio.dio.spring.security.jwt.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;
    @PostMapping
    public void postUser(@RequestBody User user){
        this.service.createUser(user);
    }
    
    @GetMapping
    public List<User> findAll(){
    	return this.service.findAll();
    }
    
    @GetMapping("{userId}")
    public User findById(@PathVariable("userId") Integer userId) {
    	return this.service.findById(userId);
    }
    
    @DeleteMapping("{userId}")
    public void delete(@PathVariable("userId") Integer userId) {
    	this.service.delete(userId);
    }
    
}