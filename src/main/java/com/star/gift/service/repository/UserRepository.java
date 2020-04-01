package com.star.gift.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.star.gift.entity.User;
@Repository
public interface UserRepository  extends JpaRepository<User,Long>{

}
