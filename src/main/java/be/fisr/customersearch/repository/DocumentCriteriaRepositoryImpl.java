package be.fisr.customersearch.repository;

import be.fisr.customersearch.entity.DocumentJpaEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/* carlpeters created on 24/07/2025 inside the package - be.fisr.customersearch.repository */
@AllArgsConstructor
@Repository
public class DocumentCriteriaRepositoryImpl implements DocumentCriteriaRepository {
    @PersistenceContext
    private final EntityManager entityManager;


    @Override
    public List<DocumentJpaEntity> findDocumentsByCriteria(String name, BigDecimal minPrice, BigDecimal maxPrice) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<DocumentJpaEntity> cq = cb.createQuery(DocumentJpaEntity.class);
        Root<DocumentJpaEntity> root = cq.from(DocumentJpaEntity.class);

        List<Predicate> predicates = new java.util.ArrayList<>();
        if (name != null && !name.isEmpty()) {
            predicates.add(cb.like(root.get("name"), "%" + name + "%"));
        }
        if (minPrice != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("price"), minPrice));
        }
        if (maxPrice != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("price"), maxPrice));
        }
        cq.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(cq).getResultList();
    }
}
