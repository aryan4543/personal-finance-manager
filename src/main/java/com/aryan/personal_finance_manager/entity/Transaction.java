package com.aryan.personal_finance_manager.entity;

import com.aryan.personal_finance_manager.enums.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data // generates getters, setters, toString, equals, hashCode
@NoArgsConstructor // generates no-arg constructor
@AllArgsConstructor // generates constructor with all fields
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotNull(message = "Amount is required")
    @Min(value = 1, message = "Amount must be at least 1")
    private Double amount;

    @NotNull(message = "Category is required")
    @Enumerated(EnumType.STRING)
    private Category category;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")  // <-- formatting happens here
    private LocalDateTime timestamp = LocalDateTime.now();

    // Custom setter
    public void setAmount(Double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.amount = amount;
    }
}


