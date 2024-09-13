package edu.gustavo.dev_week_publicando_api_restful_na_nuvem.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "tb_user")
/* A anotação Entity possui um atributo opcional "name":
 * @Entity(name = tb_user): Define o nome da entidade como "tb_user" em 
 * vez de usar o nome da classe Account, neste caso.
*/
public class User {

    @Id //identifica a chave primária da minha entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) //O banco de dados gera automaticamente um valor único para a chave primária.
    private int id;

    private String name;

    /*
     * Um conta para cada usuário, CascadeType.ALL indica que todas as operações
     * relizadas em User terão efeito na entidade Account, por exemplo, se um usuário for deletado,
     * não faz sentido a sua conta continuar existindo. Isso quer dizer que a tabela de User tenha
     * uma chave estrangeira com a tabela de Account.
    */
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Card card;
    
    /*
     * One User to Many List<Feature>, um Usuário pode ter muitas features.
    */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Feature> features;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<News> news;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public List<Feature> getFeatures() {
        return features;
    }
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
    public Card getCard() {
        return card;
    }
    public void setCard(Card card) {
        this.card = card;
    }
    public List<News> getNews() {
        return news;
    }
    public void setNews(List<News> news) {
        this.news = news;
    }
    
    

}
