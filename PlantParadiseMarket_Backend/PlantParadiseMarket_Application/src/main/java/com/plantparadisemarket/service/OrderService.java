package com.plantparadisemarket.service;

import java.util.List;

import com.plantparadisemarket.exception.NurseryException;
import com.plantparadisemarket.model.OrderStatus;
import com.plantparadisemarket.model.Orders;

public interface OrderService {
   public Orders placeSeedOrders(Integer customerId,Integer seeId,Orders order) throws NurseryException;
   public Orders placePlantOrders(Integer customerId,Integer plantId,Orders order);
   public Orders placePlanterOrders(Integer customerId,Integer planterId,Orders order);
   
   public Orders viewOrders(Integer bookingOrderId);
   
   public String deleteOrders(Integer bookingOrderId);
   
   public String updateStatus(Integer bookingOrderId,OrderStatus status);
   
   public List<Orders> viewAllOrders();
}
