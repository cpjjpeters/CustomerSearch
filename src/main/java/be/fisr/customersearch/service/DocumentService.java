package be.fisr.customersearch.service;

import be.fisr.customersearch.entity.DocumentJpaEntity;
import be.fisr.customersearch.repository.DocumentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/* carlpeters created on 24/07/2025 inside the package - be.fisr.customersearch.service */
@Service
@AllArgsConstructor
public class DocumentService {
    private final DocumentRepository documentRepository;

    @Transactional
    public void fetchDocuments() {
        // Logic to fetch documents from the database
        // This method should be implemented to interact with the repository layer
        // and retrieve the documents as per the application's requirements.
        var document = new DocumentJpaEntity();
        document.setName("document");
        var matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        var example = Example.of(document, matcher);
        var documents = documentRepository.findAll(example);
        documents.forEach(doc -> System.out.println(doc.getName()));

    }

    public void fetchDocumentsByCriteria() { //String name, BigDecimal minPrice, BigDecimal maxPrice
        // Logic to fetch documents by criteria
        // This method should be implemented to interact with the repository layer
        // and retrieve the documents based on the provided criteria.
        var documents = documentRepository.findDocumentsByCriteria(null, BigDecimal.valueOf(1), BigDecimal.valueOf(40));
        documents.forEach(doc -> System.out.println(doc.getName()));
    }
}
