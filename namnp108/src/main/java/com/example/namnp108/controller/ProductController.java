package com.example.namnp108.controller;

import com.example.namnp108.model.Product;
import com.example.namnp108.reponsitory.ProductReponsitry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v2.0/product")
public class ProductController {

    @Autowired
    ProductReponsitry prdouctRp;

    @GetMapping()
    public ResponseEntity findAll(){
        return ResponseEntity.ok(prdouctRp.findAll());
    }


    @GetMapping
    public ResponseEntity getAll(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "page_size") int page_size
    ){
        Page<Product> page1 = prdouctRp.findAll(PageRequest.of(page,page_size));
        return ResponseEntity.ok(page1);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Product product){
        return ResponseEntity.ok(prdouctRp.save(product));
    }

    @GetMapping("/sreach")
    public ResponseEntity sreachAndPage(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "page_size") int page_size
    )
    {
        return ResponseEntity.ok( prdouctRp.findBy(name,PageRequest.of(page,page_size)));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Product product){

        return ResponseEntity.ok(prdouctRp.save(product));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id){
        prdouctRp.deleteById(id);
        return ResponseEntity.ok("thành công");
    }






}
