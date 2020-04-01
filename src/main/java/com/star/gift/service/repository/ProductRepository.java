package com.star.gift.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.star.gift.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>  {

}
