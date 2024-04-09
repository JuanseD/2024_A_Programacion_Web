package com.example.backend_postgresql.repositories;

import com.example.backend_postgresql.model.ProductComboAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductComboAmountRepository extends JpaRepository<ProductComboAmount, Long> {


}
