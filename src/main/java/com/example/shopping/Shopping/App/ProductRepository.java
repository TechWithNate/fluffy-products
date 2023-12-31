package com.example.shopping.Shopping.App;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    //@Query("SELECT FROM s WHERE s.productName = ?1")
    Optional<Product> findByProductName(String productName);
}
