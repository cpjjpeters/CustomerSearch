package be.fisr.customersearch.api;


import java.util.List;

import be.fisr.customersearch.entity.Customer;
import be.fisr.customersearch.model.SearchCriteriaRequest;
import be.fisr.customersearch.model.SearchResponse;
import be.fisr.customersearch.service.AdvanceSearchService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/demo-service")
public class CustomerResource {
    private final AdvanceSearchService advanceSearchService;

    @GetMapping(value = "/all")
    public List<Customer> findAll() {
        log.debug("findAll Customers");
        return advanceSearchService.findAllCustomers();
    }

    @PostMapping("/advance-search")
    public ResponseEntity<List<SearchResponse>> searchByCriteria(@RequestBody SearchCriteriaRequest searchCriteria) {
        log.info("Search criteria: {}", searchCriteria);
        return ResponseEntity.ok(advanceSearchService.searchCustomerByCriteria(searchCriteria));
    }

}