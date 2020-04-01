package com.star.gift.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.star.gift.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
