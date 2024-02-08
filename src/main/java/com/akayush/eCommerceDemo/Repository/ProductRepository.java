package com.akayush.eCommerceDemo.Repository;

import com.akayush.eCommerceDemo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}

