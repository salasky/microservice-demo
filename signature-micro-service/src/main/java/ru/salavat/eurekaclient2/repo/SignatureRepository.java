package ru.salavat.eurekaclient2.repo;

import com.salavat.entity.Signature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
/**
 * Репозиторий для работы с подписями
 */
public interface SignatureRepository extends JpaRepository<Signature, UUID> {
}
