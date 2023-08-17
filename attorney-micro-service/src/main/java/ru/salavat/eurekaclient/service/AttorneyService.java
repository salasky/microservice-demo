package ru.salavat.eurekaclient.service;

import com.salavat.dto.AttorneyDTO;

import java.util.Collection;
import java.util.UUID;

/**
 * Интерфейс для работы с репозитрорием Attorney
 */
public interface AttorneyService {
    /**
     * Сохранение доверенности
     * @param attorney
     * @return AttorneyDTO
     */
    AttorneyDTO save(AttorneyDTO attorney);

    /**
     * Получить доверенность по id
     * @param id доверенности
     * @return AttorneyDTO
     */
    AttorneyDTO getById(UUID id);

    /**
     * Получить доверенность по guid
     * @param guid доверенности
     * @return AttorneyDTO
     */
    AttorneyDTO findByGuid(UUID guid);

    /**
     * Получить все доверенности
     *
     * @return Collection<AttorneyDTO>
     */
    Collection<AttorneyDTO> getAll();

    /**
     * Удалить доверенность
     *
     * @param id доверенности
     */
    void delete(UUID id);

    /**
     * Удалить все доверенности
     */
    void deleteAll();

}
