package com.cydeo.repository;

import com.cydeo.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface    CartRepository extends JpaRepository<Cart, Long> {
    // whatever inside this method implementation has to be SQL
// findBy(Long id);// hey DB, i need student with id 2
    //we don't see that one, implementation is ready by Spring

}
