package com.eldar.development.challenge.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//TODO EMPTY CLASS AS I'M NOT USING A DATABASE RIGHT NOW.
@Entity
public class CreditCardEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
