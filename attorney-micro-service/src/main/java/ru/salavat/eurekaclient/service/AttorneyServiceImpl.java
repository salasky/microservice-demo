package ru.salavat.eurekaclient.service;

import com.salavat.entity.Attorney;
import ru.salavat.eurekaclient.dto.AttorneyDTO;
import ru.salavat.eurekaclient.mapper.AttorneyMapper;
import ru.salavat.eurekaclient.repo.AttorneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Сервис для работы с доверенностями
 */
@Service
public class AttorneyServiceImpl implements AttorneyService {

    @Autowired
    private AttorneyRepository attorneyRepository;

    @Autowired
    private AttorneyMapper mapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public AttorneyDTO save(AttorneyDTO attorneyDTO) {
        //логика фасадного сервиса
        Attorney attorney = mapper.toAttorney(attorneyDTO);
        return mapper.toDTO(attorneyRepository.save(attorney));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AttorneyDTO getById(UUID id) {
        Optional<Attorney> optionalAttorney = attorneyRepository.findById(id);
        if(optionalAttorney.isPresent()){
            return mapper.toDTO(optionalAttorney.get());
        }
        return null;
    }

    @Override
    public AttorneyDTO findByGuid(UUID guid) {
        Optional<Attorney> optionalAttorney = attorneyRepository.findAttorneyByGuid(guid);
        if(optionalAttorney.isPresent()){
            return mapper.toDTO(optionalAttorney.get());
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<AttorneyDTO> getAll() {
        List<Attorney> attorneyList = attorneyRepository.findAll();
        return mapper.toDTOList(attorneyList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(UUID id) {
        attorneyRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAll() {
        attorneyRepository.deleteAll();
    }
}
