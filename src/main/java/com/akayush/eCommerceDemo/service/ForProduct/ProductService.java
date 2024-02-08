package com.akayush.eCommerceDemo.service.ForProduct;

import com.akayush.eCommerceDemo.DTO.ProductDto;
import com.akayush.eCommerceDemo.Model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(ProductDto productDto);
    List<Product> getAllProducts();

    Product updateProduct(Long productId, ProductDto updatedProductDto);
}
