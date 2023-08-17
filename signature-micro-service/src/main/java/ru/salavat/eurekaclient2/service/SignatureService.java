package ru.salavat.eurekaclient2.service;

import com.salavat.dto.SignatureDTO;

import java.util.Collection;
import java.util.UUID;

/**
 * Сервис для работы с документами
 */
public interface SignatureService {
    /**
     * Сохранение подписи
     * @param signatureDTO
     * @return SignatureDTO
     */
    SignatureDTO save(SignatureDTO signatureDTO);

    /**
     * Получить подпись по id
     * @param id подписи
     * @return SignatureDTO
     */
    SignatureDTO getById(UUID id);

    /**
     * Получить все подписи
     *
     * @return Collection<SignatureDTO>
     */
    Collection<SignatureDTO> getAll();

    /**
     * Удалить подпись
     *
     * @param id подписи
     */
    void delete(UUID id);

    /**
     * Удалить все подписи
     *
     */
    void deleteAll();

}