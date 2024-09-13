## Arquivo .properties:
* O arquivo .properties usa um formato de chave-valor, onde cada linha define uma configuração que é escrita como **chave=valor**. Para representar dados hierárquicos, você usa prefixos comuns:
    ```
    spring.datasource.url=jdbc:mysql://localhost:3306/mydb
    spring.datasource.username=root
    spring.datasource.password=secret
    ```
* É considerado simples e direto, ideal para configurações **básicas**.

## Arquivo .yml (YAML):
* O arquivo .yml usa uma estrutura de indentação para representar dados hierárquicos, o que o torna mais legível. As configurações são escritas com **indentação** e podem incluir listas e mapas. Por exemplo:
    ```
    spring:
    datasource:
        url: jdbc:mysql://localhost:3306/mydb
        username: root
        password: secret
    ```

* A estrutura hierárquica é mais clara e fácil de ler, especialmente para configurações **complexas**. 

Resumo
.properties: Melhor para configurações simples e diretas. Usa um formato de chave-valor.
.yml: Melhor para configurações complexas e hierárquicas. Usa uma estrutura de indentação que melhora a legibilidade.

## Usando um arquivo YAML em um projeto Spring Boot:

* Primeiramente, remova os arquivos dentro do pacote de resources e, então, crie um arquivo chamado application.yml lá ```src/main/resources``` do seu projeto. Este arquivo será usado para definir as **configurações do seu aplicativo**.
