## Mapeamento Objeto Relacional (ORM):

É uma técnica que permite converter dados entre sistemas incompatíveis usando a orientação a objetos. No contexto do Spring Boot, usamos o Spring Data JPA (Java Persistence API) para facilitar esse mapeamento.

Aqui estão algumas das anotações mais comuns usadas no ORM com Spring Boot:

* **@Entity**: Marca uma classe como uma entidade persistente. Isso significa que a classe será mapeada para uma tabela no banco de dados.
* **@Table**: Especifica detalhes da tabela associada à entidade, como o nome da tabela.
* **@Id**: Marca um campo como a chave primária da entidade.
* **@GeneratedValue**: Define a estratégia de geração de valores para a chave primária por exemplo:
    ```java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    ```
    * **GenerationType.IDENTITY**: O banco de dados gera automaticamente um valor único para a chave primária.
* **@Column**: Mapeia um campo da entidade para uma coluna específica no banco de dados: por exemplo, defini que um coluna não pode ter mais que 100 caracteres ou que não pode ser nulo, por exemplo.
    ```java
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    ```
    * Nesse caso, a coluna (ou seja, o atributo de classe) firstName do banco bando de dados será, especificadamente chamado de <b>first_name</b>, não poderá receber um valor nulo (ou seja, não poderá não ser especificado) e terá um tamanho de 50 caracteres;
* **@OneToOne**: Define um relacionamento um-para-um entre duas entidades.
    * @OneToOne(cascade = CascadeType.ALL): Indica que todas as operações (persistir, mesclar, remover, atualizar, desanexar) realizadas em uma entidade serão propagadas para a entidade mapeada:
    ```java
    import javax.persistence.Entity;
    import javax.persistence.Id;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.OneToOne;
    import javax.persistence.CascadeType;
    import javax.persistence.JoinColumn;

    @Entity
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;

        @OneToOne(cascade = CascadeType.ALL) // aplicação do cascade;
        @JoinColumn(name = "address_id")
        private Address address;

        // Getters and setters
    }

    @Entity
    public class Address {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String street;
        private String city;

        @OneToOne(mappedBy = "address") //atribudo da entidade mapeada;
        private User user;

        // Getters and setters
    }
    ```
* **@ManyToOne**: Define um relacionamento muitos-para-um entre duas entidades.
    * O FetchType.EAGER é uma estratégia de carregamento de dados usada no JPA (Java Persistence API). Quando você define um relacionamento com fetch = FetchType.EAGER, isso significa que a entidade relacionada será carregada imediatamente junto com a entidade principal, no momento em que a consulta é executada.
    ```java
        @Entity
        public class Author {
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        private String name;

        @OneToOne(fetch = FetchType.EAGER)
        private Book book;

        // Getters and setters
    }

    @Entity
    public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
       
        private String title;

        // Getters and setters
    }
    ```
    * EAGER: Quando você busca um Author, o JPA automaticamente carrega o Book associado, mesmo que você não o utilize imediatamente. Isso pode ser útil quando você sabe que sempre precisará dos dados relacionados.
* **@OneToMany**: Define um relacionamento um-para-muitos entre duas entidades.
* **@ManyToMany**: Define um relacionamento muitos-para-muitos entre duas entidades.
* **@JoinTable**: Especifica uma tabela de junção para mapear um relacionamento muitos-para-muitos.
* **@JoinColumn**: Especifica a coluna de junção em um relacionamento