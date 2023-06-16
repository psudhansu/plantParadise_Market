package com.plantparadisemarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.plantparadisemarket.model.OrderStatus;
import com.plantparadisemarket.model.Orders;
import com.plantparadisemarket.model.Plant;
import com.plantparadisemarket.model.Planter;
import com.plantparadisemarket.model.Seed;
import com.plantparadisemarket.service.OrderService;

import jakarta.validation.Valid;

@RestController
public class OrderController {
 @Autowired
 private OrderService os;
 
 @PostMapping("/seedOrder/{seedId}/{customerId")
 public ResponseEntity<Orders> seedOrder(@Valid @PathVariable("seedId") Integer seedId, @PathVariable("customerId") Integer customerId,@RequestBody Orders order){
	 Orders or = os.placeSeedOrders(customerId, seedId, order);
	 return new ResponseEntity<Orders>(or,HttpStatus.ACCEPTED);
 }
 
 @PostMapping("/plantOrder/{plantId}/{customerId")
 public ResponseEntity<Orders> PlantOrder(@Valid @PathVariable("plantId") Integer plantId, @PathVariable("customerId") Integer customerId,@RequestBody Orders order){
	 Orders por = os.placePlantOrders(customerId, plantId, order);
	 return new ResponseEntity<Orders>(por,HttpStatus.ACCEPTED);
 }
 
 @PostMapping("/planterOrder/{planterId}/{customerId")
 public ResponseEntity<Orders> PlanterOrder(@Valid @PathVariable("planterId") Integer planterId, @PathVariable("customerId") Integer customerId,@RequestBody Orders order){
	 Orders ptor = os.placePlanterOrders(customerId, planterId, order);
	 return new ResponseEntity<Orders>(ptor,HttpStatus.ACCEPTED);
 }
 
 @GetMapping("/orders/{bookingOrderId}")
 public ResponseEntity<Orders> viewById (@PathVariable("bookingOrderId") Integer bookingOrderId){
	 Orders or = os.viewOrders(bookingOrderId);
	 return new ResponseEntity<Orders>(or,HttpStatus.OK);
 }
 
 @DeleteMapping("/orders/{bookingOrderId}")
 public ResponseEntity<String> deleteById (@PathVariable("bookingOrderId") Integer bookingOrderId){
	String s= os.deleteOrders(bookingOrderId);
	 return new ResponseEntity<String>(s,HttpStatus.OK);
 }
 
 @PatchMapping("/order/{bookingOrderId}/status/{orderStatus}")
 public void updateOrderStatus(@PathVariable Integer bookingOrderId, @PathVariable OrderStatus orderStatus) {
     os.updateStatus(bookingOrderId, orderStatus);
 }
 
 @GetMapping("/orders")
 public ResponseEntity<List<Orders>> viewAllSeed() {
     List<Orders> ord = os.viewAllOrders();
     return ResponseEntity.ok(ord);
 }
}
