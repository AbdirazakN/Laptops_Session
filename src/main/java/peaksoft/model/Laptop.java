package peaksoft.model;

import lombok.*;
import peaksoft.enums.OperationSystem;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "laptops")
@NoArgsConstructor
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "laptop_id_generator")
    @SequenceGenerator(
            name = "laptop_id_generator",
            sequenceName = "laptop_seq",
            allocationSize = 1
    )
    private Long id;
    private String brand;
    @Column(name = "operation_system")
    @Enumerated(EnumType.STRING)
    private OperationSystem operationSystem;
    private double memory;
    private double price;
    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;

    public Laptop(String brand, OperationSystem operationSystem, double memory, double price, LocalDate dateOfIssue) {
        this.brand = brand;
        this.operationSystem = operationSystem;
        this.memory = memory;
        this.price = price;
        this.dateOfIssue = dateOfIssue;
    }
}
