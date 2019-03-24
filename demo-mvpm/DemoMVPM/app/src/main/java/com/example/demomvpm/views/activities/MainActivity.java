package com.example.demomvpm.views.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demomvpm.R;
import com.example.demomvpm.presenters.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private LoginPresenter loginPresenter;

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.bt_login)
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter();
    }

    @OnClick(R.id.bt_login)
    public void onViewClicked() {
        if(loginPresenter.checkLogin(
                etUsername.getText().toString(),
                etPassword.getText().toString()
        )){
            Toast.makeText(MainActivity.this, "Login successfully!!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "Login unsucessfully", Toast.LENGTH_SHORT).show();
        }
    }
}
