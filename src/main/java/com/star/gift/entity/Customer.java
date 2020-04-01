package com.star.gift.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long customerId;
private String customerName;
private String customerEmail;
private String phoneNumber;
@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
private List<Cart> cartList;

}
