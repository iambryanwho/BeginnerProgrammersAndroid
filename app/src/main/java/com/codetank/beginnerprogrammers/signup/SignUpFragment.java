package com.codetank.beginnerprogrammers.signup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.codetank.beginnerprogrammers.R;

/**
 * Created by manny on 6/15/16.
 */
public class SignUpFragment extends Fragment implements View.OnClickListener {

    private EditText userName;
    private EditText userEmail;
    private EditText userPassword;
    private EditText userConfirmPassword;
    private Button userSignUpBtn;

    public SignUpFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sign_up_fragment_main, container, false);

        userName = (EditText) view.findViewById(R.id.userNameET);
        userEmail = (EditText) view.findViewById(R.id.userEmailET);
        userPassword = (EditText) view.findViewById(R.id.userPasswordET);
        userConfirmPassword = (EditText) view.findViewById(R.id.userConfirmPasswordET);
        userSignUpBtn = (Button) view.findViewById(R.id.userSignUpBtn);

        userSignUpBtn.setOnClickListener(this);

        return view;
    }

    public void singUp(){
        if(!loginCredentialsValidated()){
            return;
        }

        //TODO: Create user functionality
    }

    public boolean loginCredentialsValidated(){
        boolean isValid = true;

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(userEmail.getText().toString()).matches()){
            isValid = false;
        }

        if(userName.length() < 4){
            //UserName length is less than 4
            isValid = false;
        }

        if(userPassword.length() < 5){
            //Password length is less than 5
            isValid = false;
        }

        if (!userPassword.getText().toString().equals(userConfirmPassword.getText().toString())){
            //passwords do not the match
            isValid = false;
        }
        return isValid;
    }

    public void clearSignUpText(){

        userName.getText().clear();
        userEmail.getText().clear();
        userPassword.getText().clear();
        userConfirmPassword.getText().clear();
    }

    @Override
    public void onClick(View v) {
        singUp();
    }
}