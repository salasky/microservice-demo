package ru.salavat.eurekaclient.controller;

import com.salavat.entity.Attorney;
import ru.salavat.eurekaclient.dto.AttorneyDTO;
import ru.salavat.eurekaclient.service.AttorneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

/**
 * Контроллер для работы с доверенностями
 */
@RestController
@RequestMapping("/attorney")
public class AttorneyController {

    @Autowired
    private AttorneyService attorneyService;

    @Value("${eureka.instance.instance-id}")
    private String id;

    @Value("${tempvar}")
    private String tempvar;

    @GetMapping("/test")
    public ResponseEntity<String> getTestString(){
        return ResponseEntity.ok(id+" "+tempvar);
    }

    /**
     * Получить все доверенности
     */
    @GetMapping("")
    public ResponseEntity<Collection<AttorneyDTO>> getAll(){
        return new ResponseEntity<>(attorneyService.getAll(), HttpStatus.OK);
    }

    /**
     * Получить доверенность по id
     */
    @GetMapping("/{id}")
    public ResponseEntity<AttorneyDTO> getById(@PathVariable UUID id){
        return new ResponseEntity<>(attorneyService.getById(id), HttpStatus.OK);
    }

    /**
     * Сохранить доверенность
     */
    @PostMapping("/save")
    public ResponseEntity<AttorneyDTO> save(@RequestBody AttorneyDTO attorneyDTO){
        return new ResponseEntity<>(attorneyService.save(attorneyDTO), HttpStatus.OK);
    }

    /**
     * Удалить доверенность
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id){
        attorneyService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Удалить доверенности
     */
    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAll(){
        attorneyService.deleteAll();
        return new ResponseEntity(HttpStatus.OK);
    }
}
