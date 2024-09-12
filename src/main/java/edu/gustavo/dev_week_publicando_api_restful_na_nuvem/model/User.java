package edu.gustavo.dev_week_publicando_api_restful_na_nuvem.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "tb_user")
/* A anotação Entity possui um atributo opcional "name":
 * @Entity(name = tb_user): Define o nome da entidade como "tb_user" em 
 * vez de usar o nome da classe Account, neste caso.
*/
public class User {
    @Id
    private String name;
    @OneToOne //um conta para cada usuário
    private Account account;
    @ManyToOne //muitos para um do ponto de vista de usuários, ou seja, muitas features para um usário
    private List<Feature> features;
    @OneToOne
    private Card card;
    @ManyToOne
    private List<News> news;
    
}
