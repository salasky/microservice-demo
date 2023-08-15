package ru.salavat.eurekaclient2.repo;

import com.salavat.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
/**
 * Репозиторий для работы с документами
 */
public interface DocumentRepository extends JpaRepository<Document, UUID> {
}
