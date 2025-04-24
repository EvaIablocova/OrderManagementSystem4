package org.example.ordermanagementsystem4.BL.users;

import org.example.ordermanagementsystem4.BL.interfaces.UserInterface;

public class AdminUser implements UserInterface {
    @Override
    public String getUserType() {
        return "Admin User";
    }
}
