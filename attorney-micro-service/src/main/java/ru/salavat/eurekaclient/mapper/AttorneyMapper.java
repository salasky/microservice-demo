package ru.salavat.eurekaclient.mapper;

import com.salavat.entity.Attorney;
import com.salavat.dto.AttorneyDTO;
import org.mapstruct.Mapper;

import java.util.Collection;

/**
 * Маппер для Attorney и {@link AttorneyDTO}
 */
@Mapper(componentModel = "spring")
public interface AttorneyMapper {
    AttorneyDTO toDTO(Attorney attorney);
    Attorney toAttorney(AttorneyDTO attorneyDTO);
    Collection<AttorneyDTO> toDTOList(Collection<Attorney> attorneyCollection);
    Collection<Attorney> toAttorneyList(Collection<AttorneyDTO> attorneyDTOCollection);
}
