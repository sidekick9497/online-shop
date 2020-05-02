package com.cognizant.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.productservice.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
