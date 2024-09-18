## Entidades (classes marcadas com @Entity) herdando de outras classes não-entidade

A anotação **@MappedSuperclass** é usada no JPA para definir uma classe cujos campos serão herdados por entidades, mas que **não será mapeada para uma tabela no banco de dados** por si só. <u>Isso é útil para compartilhar atributos comuns entre várias entidades sem criar uma tabela separada para a classe base.</u>

* Características Principais:
    * **Não é uma Entidade**: Uma classe anotada com **@MappedSuperclass** não é uma entidade e, portanto, não será persistida diretamente no banco de dados.
* Herança de Campos:  
    * Os campos da classe **@MappedSuperclass** são herdados pelas subclasses e mapeados para as tabelas correspondentes das subclasses.
* Sem Consultas Diretas: 
    * Não é possível realizar consultas diretamente na classe **@MappedSuperclass**.
