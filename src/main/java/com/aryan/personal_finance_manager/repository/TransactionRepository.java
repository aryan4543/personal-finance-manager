package com.aryan.personal_finance_manager.repository; // 1️⃣ Package declaration

import com.aryan.personal_finance_manager.entity.Transaction; // 2️⃣ Import Transaction Entity
import org.springframework.data.jpa.repository.JpaRepository;  // 3️⃣ Import JpaRepository
import org.springframework.stereotype.Repository;              // 4️⃣ Import Repository annotation

@Repository  // 5️⃣ Marks this interface as a Spring-managed bean
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // 6️⃣ We extend JpaRepository with the entity type (Transaction) and its ID type (Long)
    // No need to write any methods here — basic CRUD is auto-implemented by Spring!
}

