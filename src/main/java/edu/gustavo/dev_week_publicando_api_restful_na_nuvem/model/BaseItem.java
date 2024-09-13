package edu.gustavo.dev_week_publicando_api_restful_na_nuvem.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
/*
 * MappedSuperclass indica que esta classe não é uma entidade, mas que entidades
 * no meu projeto podem herdar desta classe. Além disso, por não ser uma entidade, não
 * possui persistência de informações. Além disso, o @MappedSuperclass permite usar 
 * anotações de entidade como @Id, @GenatedValue, uma vez que esta classe estenderá outras
 * entidades;
 */

 /*
  * Após analisar as classes Feature e News, constatou-se que ambas são muito semelhante
  * e, por isso, de acordo com o padrão de projeto DRY (don't repeat yourself) e seguindo
  * as boas práticas de orientação a objetos, criou-se a classe BaseItem, que contém todas
  * as similaridades dessa classes anteriormente citadas.
  */
public abstract class BaseItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String icon;
    private String description;

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
