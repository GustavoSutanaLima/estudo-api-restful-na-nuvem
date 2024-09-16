package edu.gustavo.dev_week_publicando_api_restful_na_nuvem.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.gustavo.dev_week_publicando_api_restful_na_nuvem.model.User;
import edu.gustavo.dev_week_publicando_api_restful_na_nuvem.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User userToCreate){
        User userCreated = userService.createUser(userToCreate);

        /* 
         * A linha de código é usada para construir uma URI (Uniform Resource Identifier) 
         * que aponta para o recurso recém-criado. Isso é comum em APIs RESTful quando você cria 
         * um novo recurso e deseja retornar a localização desse recurso no cabeçalho da resposta HTTP.
         * ServletUriComponentsBuilder.fromCurrentRequest():
         *      Cria uma instância de ServletUriComponentsBuilder com base na URI da solicitação atual. 
         *      Isso significa que a URI construída será relativa à URI da solicitação que está sendo processada.
         * .path("/{id}")
         *      Adiciona um segmento de caminho à URI. O {id} é um placeholder que será substituído pelo 
         *      valor real mais tarde.
         * .buildAndExpand(userCreated.getId()):
         *      Substitui o placeholder {id} pelo valor real, ou seja, userCreated.getId() obtém o ID do usuário 
         *      recém-criado. O método buildAndExpand substitui {id} pelo valor retornado por userCreated.getId().
         *      ->.path("/{id}") e buildAndExpand(userCreated.getId()), funcionam em conjunto para que a substituição
         *      aconteça;
         * .toUri():
                Converte o objeto UriComponents construído em uma instância de URI.
         * 
         * Suponha que a solicitação atual seja http://localhost:8080/api/users e o ID do usuário recém-criado 
         * seja 123. A linha de código acima construirá a URI http://localhost:8080/api/users/123;
         * 
         */
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(userCreated.getId())
            .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }
}
