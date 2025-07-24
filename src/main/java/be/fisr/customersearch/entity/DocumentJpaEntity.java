package be.fisr.customersearch.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

/* carlpeters created on 24/07/2025 inside the package - be.fisr.customersearch.entity */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "DOCUMENTS")
public class DocumentJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String boDealnumber;
    @Column
    private String book;
    @Column
    private BigDecimal price;
    @Column
    private String description;

}
