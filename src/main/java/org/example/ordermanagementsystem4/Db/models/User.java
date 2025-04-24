package org.example.ordermanagementsystem4.Db.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.ordermanagementsystem4.APresentationLayer.DTOs.UserDTO;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;
    private String username;
    private String email;
    private String password;

    private String paymentMethod;

    public User() {}

    public User(String username, String paymentMethod) {
        this.username = username;
        this.paymentMethod = paymentMethod;
    }

    public User (Long id, String role, String username, String email, String password, String paymentMethod) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.email = email;
        this.password = password;
        this.paymentMethod = paymentMethod;
    }

    public User(UserDTO userDTO) {
        this.username = userDTO.getUsername();
        this.paymentMethod = userDTO.getPaymentMethod();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.role = userDTO.getRole();
    }

}