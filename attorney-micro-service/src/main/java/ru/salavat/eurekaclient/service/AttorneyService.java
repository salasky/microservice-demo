package ru.salavat.eurekaclient.service;

import ru.salavat.eurekaclient.dto.AttorneyDTO;

import java.util.Collection;
import java.util.UUID;

/**
 * Интерфейс для работы с репозитрорием Attorney
 */
public interface AttorneyService {
    /**
     * Сохранение доверенности
     * @param attorney
     * @return Attorney
     */
    AttorneyDTO save(AttorneyDTO attorney);

    /**
     * Получить доверенность по id
     * @param id доверенности
     * @return Attorney
     */
    AttorneyDTO getById(UUID id);

    /**
     * Получить все доверенности
     *
     * @return Collection<Attorney>
     */
    Collection<AttorneyDTO> getAll();

    /**
     * Удалить доверенность
     *
     * @param id доверенности
     */
    void delete(UUID id);

}
