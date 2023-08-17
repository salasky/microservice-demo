package ru.salavat.eurekaclient2.mapper;

import com.salavat.entity.Document;
import org.mapstruct.Mapper;
import com.salavat.dto.DocumentDTO;

import java.util.Collection;


/**
 * Маппер для {@link Document} и {@link DocumentDTO}
 */
@Mapper(componentModel = "spring")
public interface DocumentMapper {
    DocumentDTO toDTO(Document document);
    Document toDocument(DocumentDTO documentDTO);
    Collection<DocumentDTO> toDTOList(Collection<Document> documentCollection);
    Collection<Document> toDocumentList(Collection<DocumentDTO> documentDTOCollection);
}
