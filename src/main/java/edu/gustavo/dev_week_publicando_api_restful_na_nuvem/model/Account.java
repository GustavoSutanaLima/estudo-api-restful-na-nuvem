package edu.gustavo.dev_week_publicando_api_restful_na_nuvem.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id
    private int id;
    private String number;
    private String agency;
    private BigDecimal balance;
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

}
