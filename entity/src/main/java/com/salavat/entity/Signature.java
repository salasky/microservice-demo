package com.salavat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * Сущность подпись
 */
@Entity
@Table(name = "signature")
public class Signature {

    /**
     * Id
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", nullable = false)
    private UUID id;

    /**
     * Контент подписи
     */
    @NotBlank
    @Size(max = 200)
    private String content;

    /**
     * Id доверенности
     */
    @NotBlank
    private UUID attorneyId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UUID getAttorneyId() {
        return attorneyId;
    }

    public void setAttorneyId(UUID attorneyId) {
        this.attorneyId = attorneyId;
    }
}