package dio.dio.spring.security.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dio.dio.spring.security.jwt.model.User;
import dio.dio.spring.security.jwt.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    
    public void createUser(User user){
        String pass = user.getPassword();
        //criptografando antes de salvar no banco
        user.setPassword(encoder.encode(pass));
        this.repository.save(user);
    }
    
    public List<User> findAll(){
    	return this.repository.findAll();
    }
    
    public User findById(Integer userId) {
    	Optional<User> users = this.repository.findById(userId);
    	
    	return users.get();
    }
    
    public void delete(Integer userId) {
    	this.repository.deleteById(userId);
    }
}