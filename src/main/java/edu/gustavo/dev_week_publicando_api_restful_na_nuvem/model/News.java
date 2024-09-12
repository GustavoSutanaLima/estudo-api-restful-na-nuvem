package edu.gustavo.dev_week_publicando_api_restful_na_nuvem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class News {
    @Id
    private int id;
    private String icon;
    private String description;
}
