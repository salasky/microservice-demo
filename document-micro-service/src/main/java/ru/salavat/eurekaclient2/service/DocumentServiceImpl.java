package ru.salavat.eurekaclient2.service;

import com.salavat.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.salavat.dto.DocumentDTO;
import org.springframework.transaction.annotation.Transactional;
import ru.salavat.eurekaclient2.mapper.DocumentMapper;
import ru.salavat.eurekaclient2.repo.DocumentRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Реализация интерфейса {@link DocumentService}
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private DocumentMapper mapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public DocumentDTO save(DocumentDTO documentDTO) {
        //логика фасадного сервиса
        Document document = mapper.toDocument(documentDTO);
        return mapper.toDTO(documentRepository.save(document));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DocumentDTO getById(UUID id) {
        Optional<Document> documentOption = documentRepository.findById(id);
        if(documentOption.isPresent()){
            return mapper.toDTO(documentOption.get());
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<DocumentDTO> getAll() {
        List<Document> documentList = documentRepository.findAll();
        return mapper.toDTOList(documentList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(UUID id) {
        documentRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAll() {
        documentRepository.deleteAll();
    }
}
