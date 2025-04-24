package org.example.ordermanagementsystem4.Db.repositories;

import org.example.ordermanagementsystem4.Db.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
