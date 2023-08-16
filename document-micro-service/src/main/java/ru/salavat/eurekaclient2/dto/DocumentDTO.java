package ru.salavat.eurekaclient2.dto;

import java.util.UUID;

/**
 * DTO для сущности {@link com.salavat.entity.Document}
 */
public class DocumentDTO {
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
    private UUID signatureId;

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
