package ru.salavat.eurekaclient2.service;

import com.salavat.entity.Signature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.salavat.dto.SignatureDTO;
import ru.salavat.eurekaclient2.mapper.SignatureMapper;
import ru.salavat.eurekaclient2.repo.SignatureRepository;
import ru.salavat.eurekaclient2.feign.AttorneyFeignClient;

import java.text.MessageFormat;
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
    private AttorneyFeignClient attorneyFeignClient;

    @Autowired
    private SignatureMapper mapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public SignatureDTO save(SignatureDTO signatureDTO) {
        if(attorneyFeignClient.findById(signatureDTO.getAttorneyId()) == null){
            throw new RuntimeException("Микросервис Attorney не доступен");
        }
        if(attorneyFeignClient.findById(signatureDTO.getAttorneyId()).getBody() == null){
            throw new RuntimeException(MessageFormat.format("Не найдена доверенность c id {0}", signatureDTO.getAttorneyId()));
        }
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
