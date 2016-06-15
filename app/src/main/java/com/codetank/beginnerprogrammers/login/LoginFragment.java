package com.codetank.beginnerprogrammers.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.codetank.beginnerprogrammers.R;

/**
 * Created by manny on 6/15/16.
 */
public class LoginFragment extends Fragment implements View.OnClickListener{

    private EditText userEmail;
    private EditText userPassword;
    private TextView forgotPassword;
    private Button loginBtn;
    private Button signUpBtn;

    public LoginFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.login_fragment_main, container, false);

        userEmail = (EditText) view.findViewById(R.id.emailET);
        userPassword = (EditText) view.findViewById(R.id.passwordET);
        forgotPassword = (TextView) view.findViewById(R.id.forgotPassword);
        loginBtn = (Button) view.findViewById(R.id.loginBtn);
        signUpBtn = (Button) view.findViewById(R.id.signUpBtn);

        forgotPassword.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
        signUpBtn.setOnClickListener(this);

        return view;
    }

    public void login(){}

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.forgotPassword:
                //forgot Fragment
                break;
            case R.id.loginBtn:
                //login();
                break;
            case R.id.signUpBtn:
                //sign up fragment
        }
    }
}
