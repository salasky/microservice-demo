package com.salavat.entity;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Сущность документ
 */
@Entity
@Table(name = "document")
public class Document {

    /**
     * Id
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", nullable = false)
    private UUID id;

    /**
     * Контент документа
     */
    @NotBlank
    @Size(max = 200)
    private String content;

    /**
     * Id доверенности
     */
    @NotNull
    private UUID signatureId;

    public Document() {
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

    public UUID getSignatureId() {
        return signatureId;
    }

    public void setSignatureId(UUID signatureId) {
        this.signatureId = signatureId;
    }
}
