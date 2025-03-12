package org.example.ordermanagementsystem2.APresentationLayer.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.example.ordermanagementsystem2.Db.models.User;

@Getter
@Setter
public class UserDTO {
    private Long id;

    private String role;
    private String username;
    private String email;
    private String password;

    private String paymentMethod;

    public UserDTO() {}

    public UserDTO(Long id, String username, String paymentMethod) {
        this.id = id;
        this.username = username;
        this.paymentMethod = paymentMethod;
    }

    public UserDTO (Long id, String role, String username, String email, String password) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.paymentMethod = user.getPaymentMethod();
        this.role = user.getRole();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

}
