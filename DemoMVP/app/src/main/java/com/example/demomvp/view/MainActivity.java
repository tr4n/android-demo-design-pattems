package com.example.demomvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demomvp.R;
import com.example.demomvp.presenter.login.LoginPresenterResponseToViewListener;
import com.example.demomvp.presenter.login.LoginPresenterLogin;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements LoginPresenterResponseToViewListener {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.bt_regitser)
    Button btRegitser;
    private LoginPresenterLogin mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mLoginPresenter = new LoginPresenterLogin(this);
    }

    @OnClick({R.id.bt_login, R.id.bt_regitser})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_login:

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                mLoginPresenter.receivedHandleLogin(username, password);
                break;
            case R.id.bt_regitser:

                break;
        }
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(MainActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(
                MainActivity.this,
                WelcomeAcitivity.class
        ));
    }

    @Override
    public void onLoginFailed() {
        Toast.makeText(MainActivity.this, "Login unsuccessfully", Toast.LENGTH_SHORT).show();
    }
}
