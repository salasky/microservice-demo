package ru.salavat.eurekaclient2.service;

import ru.salavat.eurekaclient2.dto.DocumentDTO;

import java.util.Collection;
import java.util.UUID;

/**
 * Сервис для работы с документами
 */
public interface DocumentService {
    /**
     * Сохранение документа
     * @param documentDTO
     * @return Attorney
     */
    DocumentDTO save(DocumentDTO documentDTO);

    /**
     * Получить документ по id
     * @param id документа
     * @return DocumentDTO
     */
    DocumentDTO getById(UUID id);

    /**
     * Получить все документы
     *
     * @return Collection<DocumentDTO>
     */
    Collection<DocumentDTO> getAll();

    /**
     * Удалить документ
     *
     * @param id документа
     */
    void delete(UUID id);

    /**
     * Удалить ddct документы
     *
     */
    void deleteAll();

}