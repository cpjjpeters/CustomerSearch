package be.fisr.customersearch.api;
// src/test/java/be/fisr/customersearch/api/CustomerResourceTest.java

import be.fisr.customersearch.entity.Customer;
import be.fisr.customersearch.model.SearchCriteriaRequest;
import be.fisr.customersearch.model.SearchResponse;
import be.fisr.customersearch.service.AdvanceSearchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerResourceTest {

    @Mock
    private AdvanceSearchService advanceSearchService;

    @InjectMocks
    private CustomerResource customerResource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Customer customer = new Customer();
        when(advanceSearchService.findAllCustomers()).thenReturn(List.of(customer));

        List<Customer> result = customerResource.findAll();

        assertEquals(1, result.size());
        verify(advanceSearchService, times(1)).findAllCustomers();
    }

    @Test
    void testSearchByCriteria() {
        SearchCriteriaRequest request = new SearchCriteriaRequest();
        SearchResponse response = new SearchResponse();
        when(advanceSearchService.searchCustomerByCriteria(request)).thenReturn(List.of(response));

        ResponseEntity<List<SearchResponse>> result = customerResource.searchByCriteria(request);

        assertEquals(200, result.getStatusCodeValue());
        assertEquals(1, result.getBody().size());
        verify(advanceSearchService, times(1)).searchCustomerByCriteria(request);
    }
}