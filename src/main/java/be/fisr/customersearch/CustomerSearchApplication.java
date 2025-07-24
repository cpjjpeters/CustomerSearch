package be.fisr.customersearch;

import be.fisr.customersearch.service.DocumentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class CustomerSearchApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(CustomerSearchApplication.class, args);
        var service = context.getBean(DocumentService.class);
        service.fetchDocuments();
    }

}
