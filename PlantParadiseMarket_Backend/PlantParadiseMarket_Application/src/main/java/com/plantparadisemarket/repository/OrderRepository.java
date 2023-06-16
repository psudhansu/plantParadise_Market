package com.plantparadisemarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.plantparadisemarket.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>,PagingAndSortingRepository<Orders, Integer>{

}
