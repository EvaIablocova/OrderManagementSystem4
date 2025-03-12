package org.example.ordermanagementsystem2.Db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.ordermanagementsystem2.Db.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
