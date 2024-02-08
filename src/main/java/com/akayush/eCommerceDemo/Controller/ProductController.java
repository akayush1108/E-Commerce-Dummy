package com.akayush.eCommerceDemo.Controller;

import com.akayush.eCommerceDemo.DTO.ProductDto;
import com.akayush.eCommerceDemo.Model.Product;
import com.akayush.eCommerceDemo.service.ForProduct.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable Long productId, @RequestBody ProductDto updatedProductDto) {
        return productService.updateProduct(productId, updatedProductDto);
    }
}
