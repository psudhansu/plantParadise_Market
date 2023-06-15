package com.plantparadisemarket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.plantparadisemarket.model.Seed;

public interface SeedsRepository extends JpaRepository<Seed, Integer>,PagingAndSortingRepository<Seed, Integer>{
   Optional<Seed> findBycommonName(String commonName);
}
