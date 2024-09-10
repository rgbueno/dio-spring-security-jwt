package dio.dio.spring.security.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dio.dio.spring.security.jwt.handler.BusinessException;
import dio.dio.spring.security.jwt.handler.RequiredFieldException;
import dio.dio.spring.security.jwt.model.User;
import dio.dio.spring.security.jwt.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    
    public void createUser(User user){
    	if(user.getUsername() == null)
    		throw new RequiredFieldException("username");
    	
    	if(user.getPassword() == null)
    		throw new RequiredFieldException("password");
    	
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
    	
    	if(users.isEmpty())
    		throw new BusinessException("Usuário não encontrado");
    	
    	return users.get();
    }
    
    public void delete(Integer userId) {
    	this.repository.deleteById(userId);
    }
}