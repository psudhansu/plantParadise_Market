package com.plantparadisemarket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.plantparadisemarket.exception.SeedException;
import com.plantparadisemarket.model.Seed;
import com.plantparadisemarket.repository.SeedsRepository;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class SeedServiceImpl implements SeedService {
  @Autowired
  private SeedsRepository sRepo;
	@Override
	public Seed addSeed(Seed seed) throws SeedException {
		
    	//if(customer == null) throw new SwiggyException("Customer is null") ; 
    	Optional<Seed> cus = sRepo.findById(seed.getSeedId()) ;
    	if(cus.isPresent()) throw new SeedException("Seed already present in database") ;
    		sRepo.save(seed) ;
    		log.info("customer added successfully");
		return seed;
	}

	@Override
	public Seed updateSeed(Integer seedId, Seed updatedSeed) throws SeedException {
		Seed existSeed = sRepo.findById(seedId)
                .orElseThrow(() -> new SeedException("Seed not found"));

		existSeed.setCommonName(updatedSeed.getCommonName());
		existSeed.setBloomTime(updatedSeed.getBloomTime());
		existSeed.setWatering(updatedSeed.getWatering());
		existSeed.setTypeOfSeeds(updatedSeed.getTypeOfSeeds());
        // Update other properties as needed

        return sRepo.save(existSeed);
	}

	@Override
	public String deleteSeed(Integer seedId) throws SeedException {
		Optional<Seed> opt = sRepo.findById(seedId);
		if(opt.isPresent()) {
			sRepo.deleteById(seedId);
			return "Seed delete succesfully";
		}else {
		
			throw new SeedException("Opps! Seed not found");
		}
	}

	@Override
	public Seed viewSeed(Integer seedId) throws SeedException {
		  return sRepo.findById(seedId)
	                .orElseThrow(() -> new SeedException("Seed not found"));
	}

	@Override
	public List<Seed> viewAllseed() throws SeedException {
		Pageable p = PageRequest.of(0, 5, Sort.by("commonName").ascending()) ;
		List<Seed> customersList = sRepo.findAll(p).getContent() ;
    	if(customersList.isEmpty()) throw new SeedException("Empty Seed list") ;
    	return customersList ;
	}

	@Override
	public Seed viewSeedByCommonName(String commonName) throws SeedException {
		 return sRepo.findBycommonName(commonName)
	                .orElseThrow(() -> new SeedException("Seed not found"));
	}

}
