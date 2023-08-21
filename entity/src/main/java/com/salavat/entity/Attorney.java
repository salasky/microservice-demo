package com.salavat.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", nullable = false)
    private UUID id;

    /**
     * Контент доверенности
     */
    @NotBlank
    @Size(max = 200)
    @Column(name = "content")
    private String content;

    /**
     * Guid доверенности
     */
    @NotBlank
    @Column(name = "guid")
    private UUID guid;

    public Attorney() {
    }

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

}