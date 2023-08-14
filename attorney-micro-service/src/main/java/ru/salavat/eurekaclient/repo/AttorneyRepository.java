package ru.salavat.eurekaclient.repo;

import com.salavat.entity.Attorney;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Репозиторий для работы с доверенностями
 */
public interface AttorneyRepository extends JpaRepository<Attorney, UUID> {
    /**
     * Найти доверенность по единому регистрационному номеру
     * @param guid guid доверенности
     * @return {@link Optional <Attorney>}
     */
    Optional<Attorney> findAttorneyByGuid(UUID guid);
}
