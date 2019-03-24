package com.example.demomvpm.presenters;

import com.example.demomvpm.managers.UserManager;

public class LoginPresenter {

    public LoginPresenter() {
        UserManager.getInstance().addUser("admin", "admin");
    }

    public boolean checkLogin(String username, String password){
        return UserManager.getInstance().validInformation(username, password);
    }
}
