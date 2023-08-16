package ru.salavat.eurekaclient2.service;

import com.salavat.entity.Document;
import com.salavat.entity.Signature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.salavat.eurekaclient2.dto.SignatureDTO;
import ru.salavat.eurekaclient2.mapper.SignatureMapper;
import ru.salavat.eurekaclient2.repo.SignatureRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Реализация интерфейса {@link SignatureService}
 */
@Service
public class SignatureServiceImpl implements SignatureService {

    @Autowired
    private SignatureRepository signatureRepository;

    @Autowired
    private SignatureMapper mapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public SignatureDTO save(SignatureDTO signatureDTO) {
        //логика фасадного сервиса
        Signature signature = mapper.toSignature(signatureDTO);
        return mapper.toDTO(signatureRepository.save(signature));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SignatureDTO getById(UUID id) {
        Optional<Signature> signatureOptional = signatureRepository.findById(id);
        if(signatureOptional.isPresent()){
            return mapper.toDTO(signatureOptional.get());
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<SignatureDTO> getAll() {
        List<Signature> signatureList = signatureRepository.findAll();
        return mapper.toDTOList(signatureList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(UUID id) {
        signatureRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAll() {
        signatureRepository.deleteAll();
    }
}
