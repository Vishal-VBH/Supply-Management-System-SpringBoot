package com.supplychainmanagementsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.supplychainmanagementsystem.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	Optional<Order> findByTrackingNumber(String tracking_number);
	List<Order> findByCustomerId(int id);
}
