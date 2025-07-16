package be.fisr.customersearch.model;


import lombok.Data;

@Data
public class SearchCriteria {
    private String searchKey;

    private String searchValue;

    private Operator operator;
}
