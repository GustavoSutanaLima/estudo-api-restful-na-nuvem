package edu.gustavo.dev_week_publicando_api_restful_na_nuvem.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true) //Indica que só pode haver um número de conta;
    private String number;
    private String agency;

    /*
     * O atributo de Column precision = 13 indica a quantidade de dígitos
     * Já atributo de Column precision = 2, indica que a precisão decimal dessa scale é 2;
     * daí teremos um valor numérico com a seguinte característica:
     * xxxxxxxxxxx.xx
     * ^
     * |
     * *
     * 13 dígitos sento, destes, 2 para precisão decimal
     */
    @Column(precision = 13, scale = 2) 
    private BigDecimal balance;

     //Um detalhe, sobre o nome do objeto limit, em alguns bancos de dados
     //a palavra limit pode ser uma key-word, por isso, usou-se o atributo name
     //da anotação @Column, para definir um nome customizado para a coluna de limite;
     @Column(name = "additional_limit", precision = 13, scale = 2)
    private BigDecimal limit;
    /* Sim, a classe BigDecimal em Java é altamente recomendada para aplicações que envolvem valores monetários. 
     * Aqui estão os principais motivos:
     * Precisão: BigDecimal oferece uma precisão muito maior do que tipos primitivos como double, 
     * evitando problemas de arredondamento e imprecisões;
     * Operações Aritméticas: Possui métodos específicos para operações aritméticas que permitem 
     * controlar o arredondamento e a escala dos valores;
     * Confiabilidade: É amplamente utilizada em contextos financeiros e científicos onde a exatidão é crucial.
     * Usar BigDecimal ajuda a garantir que os cálculos sejam precisos e confiáveis.
    */

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getAgency() {
        return agency;
    }
    public void setAgency(String agency) {
        this.agency = agency;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public BigDecimal getLimit() {
        return limit;
    }
    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
    

}
