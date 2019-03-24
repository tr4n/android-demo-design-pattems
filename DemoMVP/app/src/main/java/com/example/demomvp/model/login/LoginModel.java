package com.example.demomvp.model.login;

public class LoginModel {

    LoginModelResponseToPresenterListener callback;

    public LoginModel(LoginModelResponseToPresenterListener callback) {
        this.callback = callback;
    }

    public void handleLogin(String username, String password){
        if ("admin".equals(username) && "admin".equals(password)) {
            callback.onLoginSuccess();
        } else {
            callback.onLoginFailed();
        }
    }
}
