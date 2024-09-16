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