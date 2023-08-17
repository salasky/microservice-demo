package ru.salavat.eurekaclient2.mapper;

import com.salavat.entity.Signature;
import org.mapstruct.Mapper;
import com.salavat.dto.SignatureDTO;

import java.util.Collection;


/**
 * Маппер для {@link com.salavat.entity.Signature} и {@link SignatureDTO}
 */
@Mapper(componentModel = "spring")
public interface SignatureMapper {
    SignatureDTO toDTO(Signature document);
    Signature toSignature(SignatureDTO signatureDTO);
    Collection<SignatureDTO> toDTOList(Collection<Signature> signatureCollection);
    Collection<Signature> toSignatureList(Collection<SignatureDTO> signatureDTOCollection);
}
