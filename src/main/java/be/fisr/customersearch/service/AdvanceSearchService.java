package be.fisr.customersearch.service;

import be.fisr.customersearch.entity.Customer;
import be.fisr.customersearch.model.SearchCriteriaRequest;
import be.fisr.customersearch.model.SearchResponse;
import be.fisr.customersearch.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdvanceSearchService {
    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;

    public List<SearchResponse> searchCustomerByCriteria(SearchCriteriaRequest searchCriteriaRequest) {
        log.debug("Inside searchCustomerByCriteria : Search criteria: {}", searchCriteriaRequest);
        if (searchCriteriaRequest == null || searchCriteriaRequest.getSearchCriteria() == null) {
            log.error("Search criteria is null");
            return List.of();
        }
        List<Customer> customers = customerRepository.findAll(
                SearchSpecification.createSpecification(searchCriteriaRequest.getSearchCriteria()));
        return customers.stream().map(i -> modelMapper.map(i, SearchResponse.class)).toList();
    }

    public List<Customer> findAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }
}
