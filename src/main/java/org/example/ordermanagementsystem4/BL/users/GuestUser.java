package org.example.ordermanagementsystem2.BL.users;

import org.example.ordermanagementsystem2.BL.interfaces.UserInterface;

public class GuestUser implements UserInterface {
    @Override
    public String getUserType() {
        return "Guest User";
    }
}
