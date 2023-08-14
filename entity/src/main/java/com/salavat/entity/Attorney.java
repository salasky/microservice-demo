package com.salavat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

/**
 * Cущность доверенность
 */
@Entity
@Table(name = "attorney")
public class Attorney {

    /**
     * Id
     */
    @Id
    private UUID id;

    /**
     * Контент доверенности
     */
    @NotBlank
    @Size(max = 200)
    private String content;
    @NotNull
    private Date date;

    public Attorney() {
    }

    /**
     * Guid доверенности
     */
    @NotBlank
    private UUID guid;

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

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}