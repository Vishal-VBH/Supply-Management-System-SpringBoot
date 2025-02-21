package com.supplychainmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.supplychainmanagementsystem.dao.OrderDao;
import com.supplychainmanagementsystem.dto.ResponseStructure;
import com.supplychainmanagementsystem.entity.Order;
import com.supplychainmanagementsystem.exceptionpackage.IdNotFoundException;
import com.supplychainmanagementsystem.exceptionpackage.NoRecordFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderDao orderdao;
	
	public ResponseEntity<ResponseStructure<Order>> createOrder(Order order){
		Order recieveorder=orderdao.createOrder(order);
		ResponseStructure<Order> structure= new ResponseStructure<Order>();
		structure.setStatuscode(HttpStatus.CREATED.value());
		structure.setMessage("Order creation is successfull");
		structure.setData(recieveorder);
		return new ResponseEntity<ResponseStructure<Order>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Order>>> getAllOrders(){
		List<Order> orderlist=orderdao.getAllOrders();
		ResponseStructure<List<Order>> structure= new ResponseStructure<List<Order>>();
		if(!orderlist.isEmpty()) {
		structure.setStatuscode(HttpStatus.OK.value());
		structure.setMessage("All Orders fetched successfully");
		structure.setData(orderlist);
		return new ResponseEntity<ResponseStructure<List<Order>>>(structure,HttpStatus.OK);
		}
		else {
			throw new NoRecordFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Order>> deleteOrderById(int id){
		Optional<Order> opt=orderdao.deleteOrderById(id);
		ResponseStructure<Order> structure= new ResponseStructure<Order>();
		if(opt.isPresent()) {
		structure.setStatuscode(HttpStatus.ACCEPTED.value());
		structure.setMessage("Order deleted successfully");
		structure.setData(opt.get());
		return new ResponseEntity<ResponseStructure<Order>>(structure,HttpStatus.ACCEPTED);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Order>> getOrderById(int id){
		Optional<Order> opt=orderdao.getOrderById(id);
		ResponseStructure<Order> structure= new ResponseStructure<Order>();
		if(opt.isPresent()) {
		structure.setStatuscode(HttpStatus.ACCEPTED.value());
		structure.setMessage("Order fetched successfully");
		structure.setData(opt.get());
		return new ResponseEntity<ResponseStructure<Order>>(structure,HttpStatus.ACCEPTED);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Order>> getOrderByTrackingNumber(String tracking_number){
		Optional<Order> opt=orderdao.getOrderByTrackingNumber(tracking_number);
		ResponseStructure<Order> structure= new ResponseStructure<Order>();
		if(opt.isPresent()) {
		structure.setStatuscode(HttpStatus.ACCEPTED.value());
		structure.setMessage("Order fetched successfully");
		structure.setData(opt.get());
		return new ResponseEntity<ResponseStructure<Order>>(structure,HttpStatus.ACCEPTED);
		}
		else {
			throw new NoRecordFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Order>>> getOrdersByCustomerId(int id){
		List<Order> order_list=orderdao.getOrdersByCustomerId(id);
		ResponseStructure<List<Order>> structure= new ResponseStructure<List<Order>>();
		if(!order_list.isEmpty()) {
		structure.setStatuscode(HttpStatus.OK.value());
		structure.setMessage("All Orders fetched successfully");
		structure.setData(order_list);
		return new ResponseEntity<ResponseStructure<List<Order>>>(structure,HttpStatus.OK);
		}
		else {
			throw new NoRecordFoundException();
		}
	}

}
