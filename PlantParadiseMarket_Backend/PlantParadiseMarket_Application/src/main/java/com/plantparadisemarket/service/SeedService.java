package com.plantparadisemarket.service;

import java.util.List;

import com.plantparadisemarket.exception.SeedException;
import com.plantparadisemarket.model.Seed;

public interface SeedService {
  public Seed addSeed(Seed seed) throws SeedException;
  
  public Seed updateSeed(Integer seedId,Seed updatedSeed) throws SeedException;
  
  public String deleteSeed(Integer seedId) throws SeedException;
  
  public Seed viewSeed(Integer seedId) throws SeedException; 
  
  public Seed viewSeedByCommonName(String commonName) throws SeedException;
  
  public List<Seed> viewAllseed() throws SeedException; 
  
}
