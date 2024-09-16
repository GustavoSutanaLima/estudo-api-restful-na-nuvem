package edu.gustavo.dev_week_publicando_api_restful_na_nuvem.service.implementacao;


import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.gustavo.dev_week_publicando_api_restful_na_nuvem.model.User;
import edu.gustavo.dev_week_publicando_api_restful_na_nuvem.repository.UserRepository;
import edu.gustavo.dev_week_publicando_api_restful_na_nuvem.service.UserService;

@Service
public class UserServiceImplmentacao implements UserService{

    //Injeção da interface de acesso a dados:
    @Autowired
    UserRepository userRepo;

    @Override
    public User findUserById(Integer id) {
        User userToBeFound = userRepo.findById(id).orElseThrow(NoSuchElementException::new);
        return userToBeFound;
    }

    @Override
    public User createUser(User userToCreate) {
        if(userRepo.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException();
        }
        else{
            return userRepo.save(userToCreate);
        }
        
        
        
    }

}
