package be.fisr.customersearch.model;


import java.util.List;

import lombok.Data;

@Data
public class SearchCriteriaRequest {
    List<SearchCriteria> searchCriteria;
}