package org.example.ordermanagementsystem2.BL.users;

import org.example.ordermanagementsystem2.BL.interfaces.UserInterface;

public class CustomerUser implements UserInterface {
    @Override
    public String getUserType() {
        return "Customer User";
    }
}