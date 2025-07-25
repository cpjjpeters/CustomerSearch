package be.fisr.customersearch.model;


import lombok.Data;

@Data
public class SearchResponse {
    private String firstName;

    private String lastName;

    private String email;

    private String gender;

    private String accountNumber;
}
