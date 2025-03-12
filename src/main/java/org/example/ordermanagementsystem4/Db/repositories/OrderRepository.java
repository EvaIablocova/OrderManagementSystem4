package org.example.ordermanagementsystem2.Db.repositories;

import org.example.ordermanagementsystem2.Db.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
