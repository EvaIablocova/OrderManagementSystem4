package org.example.ordermanagementsystem2.BL.users;

import org.example.ordermanagementsystem2.BL.interfaces.UserInterface;

public class AdminUser implements UserInterface {
    @Override
    public String getUserType() {
        return "Admin User";
    }
}
