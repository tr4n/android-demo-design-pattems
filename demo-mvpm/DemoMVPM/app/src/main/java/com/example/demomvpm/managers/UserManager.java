package com.example.demomvpm.managers;

import com.example.demomvpm.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<UserModel> userModelList;

    private UserManager() {
        if(userModelList == null){
            userModelList = new ArrayList<>();
        }
    }

    public static UserManager getInstance(){
        return UserManagerHelper.INSTANCE;
    }
    private static class UserManagerHelper{
        private static final UserManager INSTANCE = new UserManager();
    }

    public void addUser(String username, String password){
        userModelList.add(new UserModel(username, password));
    }
    public boolean validInformation(String username, String password){
        for(UserModel userModel: userModelList){
            if(userModel.getUsername().equals(username) && userModel.getPassword().equals(password))
                return true;
        }
        return false;
    }

}
