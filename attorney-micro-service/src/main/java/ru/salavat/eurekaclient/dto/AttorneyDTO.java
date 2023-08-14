package ru.salavat.eurekaclient.dto;


import java.util.UUID;

/**
 * DTO для сущности Attorney
 */
public class AttorneyDTO {
    /**
     * Id
     */
    private UUID id;

    /**
     * Контент доверенности
     */
    private String content;

    /**
     * Guid доверенности
     */
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
}
