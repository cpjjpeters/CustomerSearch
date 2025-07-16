package be.fisr.customersearch.service;

import be.fisr.customersearch.entity.Customer;
import be.fisr.customersearch.model.SearchCriteria;
import jakarta.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class SearchSpecification {
    public static Specification<Customer> createSpecification(List<SearchCriteria> searchCriteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = searchCriteria.stream().map(criteria -> criteria.getOperator()
                    .buildCriteria(root, query, criteriaBuilder, criteria.getSearchKey(), criteria.getSearchValue())).toList();
            return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
        };
    }
}
