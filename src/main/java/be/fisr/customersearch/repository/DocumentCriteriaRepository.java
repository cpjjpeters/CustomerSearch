package be.fisr.customersearch.repository;

import be.fisr.customersearch.entity.DocumentJpaEntity;

import java.math.BigDecimal;
import java.util.List;

public interface DocumentCriteriaRepository {

    List<DocumentJpaEntity> findDocumentsByCriteria(String name, BigDecimal minPrice, BigDecimal maxPrice);  //Criteria criteria);


}
