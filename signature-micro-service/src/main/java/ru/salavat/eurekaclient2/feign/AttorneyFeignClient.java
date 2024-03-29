package ru.salavat.eurekaclient2.feign;

import com.salavat.dto.AttorneyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient(name = "eclient-attorney", fallback = AttorneyFeignClientFallback.class)
public interface AttorneyFeignClient {

    @RequestMapping(value = "/attorney/{id}}", method = RequestMethod.GET)
    ResponseEntity<AttorneyDTO> findById(@PathVariable(value = "id") UUID id);
}

@Component
class AttorneyFeignClientFallback implements AttorneyFeignClient {

    // этот метод будет вызываться, если сервис /attorney/{id} не будет доступен
    @Override
    public ResponseEntity<AttorneyDTO> findById(UUID id) {
        return null;
    }
}


