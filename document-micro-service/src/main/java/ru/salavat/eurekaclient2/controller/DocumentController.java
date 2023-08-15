package ru.salavat.eurekaclient2.controller;

import com.salavat.entity.Document;
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
import ru.salavat.eurekaclient2.dto.DocumentDTO;
import ru.salavat.eurekaclient2.service.DocumentService;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/test")
    public ResponseEntity<String> getTestString(){
        Document document = new Document();
        document.setId(UUID.randomUUID());
        document.setContent("Content");
        document.setAttorneyId(UUID.randomUUID());
        return ResponseEntity.ok("Document");
    }

    /**
     * Получить все документы
     */
    @GetMapping("")
    public ResponseEntity<Collection<DocumentDTO>> getAll(){
        return new ResponseEntity<>(documentService.getAll(), HttpStatus.OK);
    }

    /**
     * Получить доверенность по id
     */
    @GetMapping("/{id}")
    public ResponseEntity<DocumentDTO> getById(@PathVariable UUID id){
        return new ResponseEntity<>(documentService.getById(id), HttpStatus.OK);
    }

    /**
     * Сохранить документ
     */
    @PostMapping("/save")
    public ResponseEntity<DocumentDTO> save(@RequestBody DocumentDTO documentDTO){
        return new ResponseEntity<>(documentService.save(documentDTO), HttpStatus.OK);
    }

    /**
     * Удалить документ
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id){
        documentService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Удалить документы
     */
    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAll(){
        documentService.deleteAll();
        return new ResponseEntity(HttpStatus.OK);
    }
}
