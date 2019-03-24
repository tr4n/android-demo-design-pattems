package com.example.demomvp.presenter.login;

import com.example.demomvp.model.login.LoginModel;
import com.example.demomvp.model.login.LoginModelResponseToPresenterListener;

public class LoginPresenterLogin implements LoginModelResponseToPresenterListener {

    private LoginModel mLoginModel;
    private LoginPresenterResponseToViewListener callback;

    public LoginPresenterLogin(LoginPresenterResponseToViewListener callback) {
        this.callback = callback;
    }

    public void receivedHandleLogin(String username, String password){
        mLoginModel = new LoginModel(this);
        mLoginModel.handleLogin(username, password);

    }

    @Override
    public void onLoginSuccess() {
        callback.onLoginSuccess();
    }

    @Override
    public void onLoginFailed() {
        callback.onLoginFailed();
    }
}
