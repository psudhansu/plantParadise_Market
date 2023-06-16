package com.plantparadisemarket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.plantparadisemarket.exception.NurseryException;
import com.plantparadisemarket.exception.SeedException;
import com.plantparadisemarket.model.Customer;
import com.plantparadisemarket.model.OrderStatus;
import com.plantparadisemarket.model.Orders;
import com.plantparadisemarket.model.Plant;
import com.plantparadisemarket.model.Planter;
import com.plantparadisemarket.model.Seed;
import com.plantparadisemarket.repository.CustomerRepository;
import com.plantparadisemarket.repository.OrderRepository;
import com.plantparadisemarket.repository.PlantRepository;
import com.plantparadisemarket.repository.PlanterRepository;
import com.plantparadisemarket.repository.SeedsRepository;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private CustomerRepository cRepo;
	
	@Autowired
	private OrderRepository oRepo;
	
	@Autowired
	private SeedsRepository sRepo;
	
	@Autowired
	private PlantRepository pRepo;
	
	@Autowired
	private PlanterRepository prRepo;

	@Override
	public Orders placeSeedOrders(Integer customerId, Integer seeId, Orders order) throws NurseryException{
		Optional<Customer> optC = cRepo.findById(customerId);
		Optional<Seed> optS = sRepo.findById(seeId);
		if(optC.isEmpty() || optS.isEmpty() || order==null) throw new NurseryException("Item not found");
			order.setCustomer(optC.get());
			optS.get().setOrders(order);
			
			optC.get().getOrderList().add(order);
			order.getSeedList().add(optS.get());
			oRepo.save(order);
		log.info("Seed Order placed");
		return order;
	}

	@Override
	public Orders placePlantOrders(Integer customerId, Integer plantId, Orders order) {
		Optional<Customer> optC = cRepo.findById(customerId);
		Optional<Plant> optP = pRepo.findById(plantId);
		if(optC.isEmpty() || optP.isEmpty() || order==null) throw new NurseryException("Item not found");
			order.setCustomer(optC.get());
			optP.get().setOrders(order);
			
			optC.get().getOrderList().add(order);
			order.getPlantList().add(optP.get());
			oRepo.save(order);
		log.info("Plant Order placed");
		return order;
	}

	@Override
	public Orders placePlanterOrders(Integer customerId, Integer planterId, Orders order) {
		Optional<Customer> optC = cRepo.findById(customerId);
		Optional<Planter> optPr = prRepo.findById(planterId);
		if(optC.isEmpty() || optPr.isEmpty() || order==null) throw new NurseryException("Item not found");
			order.setCustomer(optC.get());
			optPr.get().setOrders(order);
			
			optC.get().getOrderList().add(order);
			order.getPlanterList().add(optPr.get());
			oRepo.save(order);
		log.info("Planter Order placed");
		return order;
	}

	@Override
	public Orders viewOrders(Integer bookingOrderId) {
		return oRepo.findById(bookingOrderId)
                .orElseThrow(() -> new NurseryException("Order not found with id :"+bookingOrderId));
	}

	@Override
	public String deleteOrders(Integer bookingOrderId) {
		Optional<Orders> opt = oRepo.findById(bookingOrderId);
		if(opt.isPresent()) {
			oRepo.deleteById(bookingOrderId);
			return "Orders delete succesfully";
		}else {
		
			throw new NurseryException("Opps! Order not found with id :"+bookingOrderId);
		}
	}

	@Override
	public String updateStatus(Integer bookingOrderId, OrderStatus status) {
		Optional<Orders> optO = oRepo.findById(bookingOrderId);
		if(optO.isEmpty()) throw new NurseryException("Order not found with id :"+bookingOrderId);
		
		if(optO.get().getOrderStatus()==OrderStatus.ORDERPLACED) {
			throw new NurseryException("Cannot change the status of a PlacedOrder ");
		}
		optO.get().setOrderStatus(status);
		oRepo.save(optO.get());
		return "OrderStatus updated succesfully";
	}

	@Override
	public List<Orders> viewAllOrders() {
		Pageable p = PageRequest.of(0, 5) ;
		List<Orders> orderList = oRepo.findAll(p).getContent() ;
    	if(orderList.isEmpty()) throw new NurseryException("Empty Order list") ;
    	return orderList ;
	}

}
