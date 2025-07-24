package be.fisr.customersearch.controller;

import be.fisr.customersearch.entity.DocumentJpaEntity;
import be.fisr.customersearch.service.DocumentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* carlpeters created on 24/07/2025 inside the package - be.fisr.customersearch.controller */
@RestController
@RequestMapping(value="/documents")
@Validated
@Slf4j
@AllArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

//    @GetMapping(value = "/all")
//    public ResponseEntity<List<DocumentJpaEntity>> getAll() {
//        log.debug("get all documents");
//        List<DocumentJpaEntity> documents = documentService.fetchDocuments();
//        if (documents.isEmpty()) {
//            return  ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(documents);
//    }
}
