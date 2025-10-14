package com.unthinkable.assignment.unthinkable_assignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unthinkable.assignment.unthinkable_assignment.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
