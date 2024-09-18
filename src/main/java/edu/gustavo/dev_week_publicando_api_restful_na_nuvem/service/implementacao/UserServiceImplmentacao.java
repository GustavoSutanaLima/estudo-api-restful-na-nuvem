package edu.gustavo.dev_week_publicando_api_restful_na_nuvem.service.implementacao;


import java.util.NoSuchElementException;
import java.util.Optional;

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

    @Override
    public User updateUser(Integer IdUserToUpdate, User userUpdate) {
        //Retorna o usuário do Id que queremos dar update nas informações, se ele existir
        Optional<User> userDB = userRepo.findById(IdUserToUpdate);

        //Se o usuário estiver presente no repositório, ou seja user.isPresent() == true
        if(userDB.isPresent()){
            //vou pegar cada uma das informações do userUpdate e vou passar para o usário no banco (userDB):
            userDB.get().setName(userUpdate.getName());
            userDB.get().setAccount(userUpdate.getAccount()); //Account
            userDB.get().setCard(userUpdate.getCard()); //Card
            userDB.get().setFeatures(userUpdate.getFeatures());; //Features
            userDB.get().setNews(userUpdate.getNews());; //News

            //depois que todas as informações do objeto foram atualizadas, é preciso salvar esse o objeto
            //modificado no banco usando o método save. é preciso salvar o .get(), pois o argumento de
            //save não pode ser nulo e, .get() garante que eu estou retornan um objeto;
            return userRepo.save(userDB.get());
        }
        else{
            throw new NoSuchElementException();
        }
    }

}
