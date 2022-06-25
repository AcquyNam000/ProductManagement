package com.example.namnp108.reponsitory;

import com.example.namnp108.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReponsitry extends JpaRepository<Product,Integer>{

    @Query("SELECT p FROM Product p WHERE p.name LIKE ?1 AND p.price > 50000 ORDER BY p.price DESC")
    List<Product> findBy(String name, Pageable pageable);
}
