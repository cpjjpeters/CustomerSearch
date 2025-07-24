package be.fisr.customersearch.repository;

import be.fisr.customersearch.entity.DocumentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

/* carlpeters created on 24/07/2025 inside the package - be.fisr.customersearch.repository */
public interface DocumentRepository extends JpaRepository<DocumentJpaEntity, Long>, DocumentCriteriaRepository {
//    List<DocumentJpaEntity> findByName(String name);
//    List<DocumentJpaEntity> findByNameContains(String name);
//    List<DocumentJpaEntity>  findByNameEndingWithIgnoreCase(String name);
//    List<DocumentJpaEntity> findByPriceGreaterThan(BigDecimal price);
//    List<DocumentJpaEntity> findByPriceBetween(BigDecimal min, BigDecimal max);
//    List<DocumentJpaEntity> findByDescriptionNull(String description);
//    // multiple conditions
//    List<DocumentJpaEntity> findByDescriptionNullAndNameEmpty(String description, String name);
//
//    List<DocumentJpaEntity> findByNameOrderByPriceAsc(String name);
//
//    List<DocumentJpaEntity> findTop5ByNameOrderByPriceAsc(String name);
////    Find products whose prices are in a given range and sort them by name in ascending order
//    List<DocumentJpaEntity> findByPriceBetweenOrderByNameAsc(BigDecimal min, BigDecimal max);
//
//    // Find products with a specific name and price greater than a certain value
//    List<DocumentJpaEntity> findByNameAndPriceGreaterThan(String name, BigDecimal price);
//
//    // Find products with a specific name and description containing a keyword
//    List<DocumentJpaEntity> findByNameAndDescriptionContaining(String name, String keyword);

//    SQL query to find documents with a price between min and max, ordered by name ascending
//    @Query(value = "SELECT documents FROM DocumentJpaEntity d WHERE d.price between :min and :max order by p.name asc",
//            nativeQuery = true)
//    List<DocumentJpaEntity> findDocuments(@Param("min")BigDecimal min, @Param("max")BigDecimal max);

//    JPQL query to find documents with a price between min and max, ordered by name ascending
    @Query( "SELECT d FROM DocumentJpaEntity d WHERE d.price between :min and :max order by d.name asc")
    List<DocumentJpaEntity> findDocumentsJPQL(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

}
