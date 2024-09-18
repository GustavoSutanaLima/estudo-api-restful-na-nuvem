package edu.gustavo.dev_week_publicando_api_restful_na_nuvem.service;

import org.springframework.stereotype.Service;
import edu.gustavo.dev_week_publicando_api_restful_na_nuvem.model.User;

@Service
public interface UserService {
    public User findUserById (Integer id);

    public User createUser(User userToCreate);

    public User updateUser(Integer IdUserToUpdate, User userToUpdate);
    
}
