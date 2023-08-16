package ru.salavat.eurekaclient2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.salavat.eurekaclient2.dto.SignatureDTO;
import ru.salavat.eurekaclient2.service.SignatureService;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/signature")
public class SignatureController {

    @Autowired
    private SignatureService signatureService;

    @GetMapping("/test")
    public ResponseEntity<String> getTestString(){
        return ResponseEntity.ok("Signature Test");
    }

    /**
     * Получить все подписи
     */
    @GetMapping("")
    public ResponseEntity<Collection<SignatureDTO>> getAll(){
        return new ResponseEntity<>(signatureService.getAll(), HttpStatus.OK);
    }

    /**
     * Получить подпись по id
     */
    @GetMapping("/{id}")
    public ResponseEntity<SignatureDTO> getById(@PathVariable UUID id){
        return new ResponseEntity<>(signatureService.getById(id), HttpStatus.OK);
    }

    /**
     * Сохранить подпись
     */
    @PostMapping("/save")
    public ResponseEntity<SignatureDTO> save(@RequestBody SignatureDTO signatureDTO){
        return new ResponseEntity<>(signatureService.save(signatureDTO), HttpStatus.OK);
    }

    /**
     * Удалить подпись
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id){
        signatureService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Удалить подписи
     */
    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAll(){
        signatureService.deleteAll();
        return new ResponseEntity(HttpStatus.OK);
    }
}
