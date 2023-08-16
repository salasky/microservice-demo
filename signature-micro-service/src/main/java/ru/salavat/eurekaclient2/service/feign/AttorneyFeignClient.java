package ru.salavat.eurekaclient2.service.feign;

import com.salavat.entity.Attorney;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@FeignClient(name = "eclient-attorney")
public interface AttorneyFeignClient {
    @PostMapping("/attorney/id")
    ResponseEntity<Attorney> getById(@PathVariable UUID id);
}
