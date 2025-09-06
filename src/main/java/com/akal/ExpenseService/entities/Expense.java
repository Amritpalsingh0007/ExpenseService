package com.akal.ExpenseService.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "user_id")
    private String userId;

    private Long amount;
    private String merchant;
    private String currency;
    @Column(name = "created_at")
    private Timestamp createdAt;

    @PrePersist
    public void checkAndUpdateBeforePersist(){
        if(this.externalId == null){
            this.externalId = UUID.randomUUID().toString();
        }
        if(this.createdAt == null){
            this.createdAt = new Timestamp(System.currentTimeMillis());
        }
    }

    @PreUpdate
    public void checkAndUpdateBeforeUpdate(){
        if(this.externalId == null){
            this.externalId = UUID.randomUUID().toString();
        }
    }
}
