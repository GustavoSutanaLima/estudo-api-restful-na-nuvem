## Railway

O [Railway](https://Railway.app) é uma plataforma de implantação que simplifica o ciclo de vida do desenvolvimento de software, desde implantações instantâneas e escalabilidade sem esforço até integrações de CI/CD e observabilidade integrada.

* **Principais Características**:
    * **Implantações Instantâneas**: Permite implantar rapidamente suas aplicações apontando para a fonte de implantação, como repositórios de código ou imagens Docker.
    * **Configuração Simples**: Oferece configurações padrão sensatas para que você possa começar rapidamente, com opções para ajustes conforme necessário.
    * **Gerenciamento de Configuração**: Facilita o gerenciamento de variáveis e dados sensíveis.
    * **Monitoramento de Implantações**: Inclui ferramentas de observabilidade para monitorar suas implantações.
    * **Integração com GitHub**: Suporte para integração automática com repositórios GitHub, facilitando o fluxo de trabalho de desenvolvimento1.
* Benefícios
    * **Facilidade de Uso**: A interface intuitiva e a configuração simplificada tornam a Railway uma escolha popular entre desenvolvedores que buscam uma solução de implantação sem complicações.
    * **Flexibilidade**: Suporta várias fontes de implantação e oferece opções de configuração detalhadas para otimização.
    * **Suporte e Comunidade**: A Railway é conhecida por seu suporte ao cliente responsivo e uma comunidade ativa de desenvolvedores.

## Contários Utéis
* Usando o Railway é possível provisionar um banco de dados SQL (em núvem) de maneira dentro dos limites de free trial do Railway. No caso desta aplicação foi criado um banco dedos PostgresSQL;

* **IMPORTANTÍSSIMO**:
    * Para conectar um banco de dados em nuvem com nosso projeto Spring Boot, é preciso criar um novo arquivo ```.yml```, uma vez que o arquivo de cofigurações que já existe em nosso projeto: ([application.yml](application.yml)), já possui uma seção ```datasource```, referente ao banco de dados em memória (H2).
    * No [Arquivos de recursos.md](Arquivos-de-recursos.md) veja a seção sobre o segundo arquivo YAML.

## Conectando com o Railway (usando o banco de dados PostgreSQL):

* No arquivo .yml de produção serão colocadas as informações pertinentes à conexão com o banco de dados, observe:

    ```yml
    spring:
    datasource:
        url: jdbc:postgresql://${PGHOST}:${PGPORT}/${PGDATABASE} 
        username: ${PGUSER}       
        password: ${PGPASSWORD}     
        driverClassName: org.postgresql.Driver
    jpa:
        hibernate:
        ddl-auto: validate
        show-sql: true
        database-platform: org.hibernate.dialect.PostgreSQLDialect
    ```
* Como estamos usando o bando de dados PostgreSQL a url se inicia com ```jdbc:postgresql```;
* Os valores ```${PGHOST}```,```${PGPORT}```, ```${PGDATABASE}```,  ```${PGUSER}``` e ```${PGPASSWORD}``` sao variáveis de ambiente (<i>environment variables</i>). Esse aquivo .yml é escrito dessa maneira para garantir a segurança das informações refentes ao banco de dados e seus valores são abribuidos, nesta caso no ```lauch.json``` do VsCode, da seguinta maneira:

    ```json
    {
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "Application",
            "request": "launch",
            "mainClass": "edu.gustavo.dev_week_publicando_api_restful_na_nuvem.Application",
            "projectName": "dev-week-publicando-api-restful-na-nuvem",
            "env": {
                "PGDATABASE": "NOME_DO_DATABASE",
                "PGHOST": "NOME_DO_HOST",
                "PGPASSWORD": "PASSWORD_HASH",
                "PGPORT": "PORTA_PUBLICA",
                "PGUSER": "NOME_DE_USUÁRIO"
            }
        }
    ]
  }
    ```
* As informações de ```NOME_DO_DATABASE```, ```NOME_DO_HOST```, ```PASSWORD_HASH```, ```PORTA_PUBLICA``` e ```NOME_DE_USUÁRIO``` são encontradas na aba ```Data``` do Railway ao lado de ```Connect to the database Postgres:``` clicando no botão ```Connect```. Após isso, no campo ```Connection URL``` você verá a seguinte url:    
    * ```postgresql://postgres:*****@autorack.proxy.rlwy.net:47474/railway```
        * ```postgres``` é o nome de usuário;
        * ```*****``` é o password hash (na verdade é um hash, mas aqui está omitido usando os asteríscos);
        * ```autorack.proxy.rlwy.net``` é o nome do host;
        * ```47474``` é a porta publica;
        * ```railway``` é o nome do data base;
    
    