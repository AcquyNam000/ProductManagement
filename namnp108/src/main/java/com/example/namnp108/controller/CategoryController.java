package com.example.namnp108.controller;

import com.example.namnp108.model.Category;
import com.example.namnp108.model.Product;
import com.example.namnp108.reponsitory.CategoryReponsitry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v2.0/category")
public class CategoryController {
    @Autowired
    CategoryReponsitry categoryRp;

    @GetMapping("")
    public ResponseEntity findAll(){

        return ResponseEntity.ok(categoryRp.findAll());
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody Category category){

        return ResponseEntity.ok(categoryRp.save(category));
    }


    @PutMapping()
    public ResponseEntity update
            (
                    @RequestBody Category categories
            ){
        return ResponseEntity.ok(categoryRp.save(categories));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete
            (
                    @PathVariable int id
            ){
        categoryRp.deleteById(id);
        return ResponseEntity.ok("thanh cong");
    }
}
