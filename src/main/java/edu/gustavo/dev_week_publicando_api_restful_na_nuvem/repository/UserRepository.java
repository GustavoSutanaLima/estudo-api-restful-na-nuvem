package edu.gustavo.dev_week_publicando_api_restful_na_nuvem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.gustavo.dev_week_publicando_api_restful_na_nuvem.model.User;

/* Anotar uma classe com o @Repository é uma boa prática, mesmo que 
 * não seja estritamente necessário neste caso, pois ao estender o 
 * UserRepository, automaticamente o Spring Boot já entende que essa
 * interface já é um repositório;
 */
@Repository 
public interface UserRepository extends JpaRepository<User, Integer> {
    /*
     * Lembrando que o repositório de uma entidade é sempre uma interface.
        
        * UserRepository é uma interface que gerencia entidades do tipo User 
        * com identificadores do tipo Integer (@Id, ou chave primária). 
        * Usando essa interface é possível realizar operações de banco de dados 
        * sem escrever SQL manualmente.
 
            * Também podem ser criados métodos personalizados para o repostório de usuários
    */

    boolean existsByAccountNumber (String accountNumber);
    /*
     * User Repository é um JpaRepostitory de Users com Id Integer 
     * (public interface UserRepository extends JpaRepository<User, Integer>)
     * Ao criar um metodo boleano aqui dentro, o próprio Spring boot consegue fazer uma inferência
     * ao atributo Account dentro de usário.
     */
}
