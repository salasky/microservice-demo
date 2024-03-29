package com.salavat.dto;

import java.util.UUID;

/**
 * DTO для сущности {@link com.salavat.entity.Signature}
 */
public class SignatureDTO {
    /**
     * Id
     */
    private UUID id;
    /**
     * Контент документа
     */
    private String content;
    /**
     * Id доверенности
     */
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
