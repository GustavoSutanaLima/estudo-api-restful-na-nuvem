<h1>Diferença entre uma Interface e uma Classe Abstrata:</h1>

## Interface
* Definição: Uma interface é um contrato que define um conjunto de métodos que uma classe deve implementar, todos os métodos são abstratos por padrão, ou seja, sem corpo (**sem implementação**).
* Herança Múltipla: Uma classe pode implementar várias interfaces, permitindo herança múltipla.
* Estado: Interfaces <b>não</b> podem ter variáveis de instância (campos), apenas constantes (variáveis static final).
* Acesso: Todos os métodos em uma interface são implicitamente públicos.
    ```java
        public interface Animal {
        void comer();
        void andar();
    }
    ```

## Classe abstrata
* Definição: Uma classe abstrata é uma classe que **não pode ser instanciada diretamente** e pode conter métodos abstratos (**sem implementação**) e concretos (**com implementação**: método tem corpo).

* Herança Única: Uma classe pode herdar de apenas uma classe abstrata.
* Estado: Classes abstratas podem ter variáveis de instância.
* Acesso: Métodos em uma classe abstrata podem ter qualquer modificador de acesso (public, protected, private).
    ```java
    public abstract class Animal {
        //Classe abstrata tem atributos
        private String name;

        //E construtores
        public Animal(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
        
        //Método abstrato, ou seja, a classe que herdar
        //desta, implmentará o método fazer barulho, que
        //significa que nem todo Animal faz barulho da mesma foma;
        public abstract void fazerBarulho();

        //já o método comer é igual para todos e 
        //possui um corpo;
        public void comer() {
            System.out.println(name + " is eating.");
        }
    }
    ```