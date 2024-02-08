package com.akayush.eCommerceDemo.Repository;

import com.akayush.eCommerceDemo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}

