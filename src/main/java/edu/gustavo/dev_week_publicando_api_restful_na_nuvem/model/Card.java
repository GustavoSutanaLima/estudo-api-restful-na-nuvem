package edu.gustavo.dev_week_publicando_api_restful_na_nuvem.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Card {
    @Id
    private int id;
    private String number;
    private BigDecimal limit;
    
}
