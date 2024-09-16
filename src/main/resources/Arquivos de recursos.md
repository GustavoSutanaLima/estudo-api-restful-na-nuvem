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

## Usando um segundo arquivo de congifuração YAML em um projeto Spring Boot

<u>É possível criar mais de um arquivo de configuração .yml para especificar perfis diferentes e ativá-los conforme necessário</u>

O arquivo principal continuará sendo o **application.yml**. Mas agora serão criados outros arquivos .yml (dentro do mesmo pacote, ou seja, ```src/main/resources```), com o seguinte padrão: ```application-[NOME_DO_PERFIL]```. Veja abaixo os perfils de "dev" (referente ao desenvolvimento) e o de "prod" (referente ao de produção):

### application-dev.yml
```yml
# application-dev.yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/devdb
    username: devuser
    password: devpass
```
### application-prod.yml
```yml
# application-prod.yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/proddb
    username: produser
    password: prodpass
```
## Ativando um dos perfis:

No arquivo application.yml (principal) será ativa o perfil que se deseja usar, da seguinte forma:
```yml
#application.yml
spring:
  profiles:
    active: dev
```
No caso do arquivo .yml acima, o perfil de dev está ativado e, portanto, será o arquivo de configuração desta aplicação.