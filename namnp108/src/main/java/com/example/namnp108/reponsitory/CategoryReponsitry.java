package com.example.namnp108.reponsitory;

import com.example.namnp108.model.Category;
import com.example.namnp108.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryReponsitry extends JpaRepository<Category,Integer> {
    List<Category> findAll();
}
