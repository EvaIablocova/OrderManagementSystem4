package org.example.ordermanagementsystem2.BL.services;

import org.example.ordermanagementsystem2.APresentationLayer.DTOs.UserDTO;
import org.example.ordermanagementsystem2.BL.interfaces.PaymentMethodInterface;
import org.example.ordermanagementsystem2.BL.interfaces.UserInterface;
import org.example.ordermanagementsystem2.BL.interfaces.UserPaymentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.ordermanagementsystem2.Db.repositories.UserRepository;
import org.example.ordermanagementsystem2.Db.models.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository UserRepository;

    @Autowired
    public UserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }


    public UserDTO create(UserDTO userDTO) {


        //UserDTO -> Concrete User

        UserPaymentFactory userPaymentFactory = UserPaymentFactoryProvider.getFactory(userDTO.getRole());

        UserInterface userNew = userPaymentFactory.createUser();
        PaymentMethodInterface paymentMethod = userPaymentFactory.createPaymentMethod();

        userDTO.setRole(userNew.getUserType());
        userDTO.setPaymentMethod(paymentMethod.getPaymentMethodId());

        User user = UserRepository.save(new User(userDTO));
        return new UserDTO(user);
    }

    public Optional<UserDTO> findById(Long id) {
        return UserRepository.findById(id).map(UserDTO::new);
    }

    public List<UserDTO> findAll() {
        return UserRepository.findAll()
                .stream()
                .map(UserDTO::new)
                .toList();
    }

    public UserDTO update(Long id, UserDTO entity) {
        User updatedUser = new User(entity);
        updatedUser.setId(id);
        return new UserDTO(UserRepository.save(updatedUser));
    }

    public void deleteById(Long id) {
        UserRepository.deleteById(id);
    }

    public void delete(UserDTO entity) {
        UserRepository.delete(new User(entity));
    }
}


