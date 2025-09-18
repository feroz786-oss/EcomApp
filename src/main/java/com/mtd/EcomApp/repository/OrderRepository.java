package com.mtd.EcomApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mtd.EcomApp.entity.Order;

public interface OrderRepository extends MongoRepository<Order, String> {

}
