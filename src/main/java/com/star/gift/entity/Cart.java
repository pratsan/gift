package com.star.gift.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter

	public class Cart 
	{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private Product product;
	private int quantity;
	private boolean flag;
	private Double price;
	private String type;
	
	@OneToMany
	@JoinColumn(name = "cartId")
	private List<User> user;
}
