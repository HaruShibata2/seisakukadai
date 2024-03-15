package jp.ac.ohara.seisakukadai.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="account")

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    
    @Column(length = 32, nullable = false)
    private String name;
    
    @Column(length = 64, nullable = false)
    private String mail;
    
    @Column(length = 126, nullable = false)
    private  String password;
    
    @Column(length = 128, nullable = false)
    private Integer blance;
    
    
    
}