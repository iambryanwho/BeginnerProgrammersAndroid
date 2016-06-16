package com.codetank.beginnerprogrammers.signup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.codetank.beginnerprogrammers.R;
import com.codetank.beginnerprogrammers.data.User;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

/**
 * Created by manny on 6/15/16.
 */
public class SignUpFragment extends Fragment implements View.OnClickListener {

    public static final String FIRE_BASE_URL = "https://bprogrammers.firebaseio.com/";
    public static final String USERS_ROUTE = "users/";
    public Firebase mFirebaseRef;

    private EditText userName;
    private EditText userEmail;
    private EditText userPassword;
    private EditText userConfirmPassword;
    private Button userSignUpBtn;

    public SignUpFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFirebaseRef = new Firebase(FIRE_BASE_URL + USERS_ROUTE);
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

        //Create user functionality
        mFirebaseRef.createUser(userEmail.getText().toString(), userPassword.getText().toString(), new Firebase.ValueResultHandler<Map<String, Object>>(){

            @Override
            public void onSuccess(Map<String, Object> result) {
                Log.d("flow", "Successfully created user account with uid: " + result.get("uid"));

                User user = new User(userEmail.getText().toString(), userName.getText().toString());
                String uid = (String) result.get("uid");

                mFirebaseRef.child(uid).setValue(user);
                clearSignUpText();
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                Log.d("flow", "ERROR: " + firebaseError.toString() + " " + firebaseError.getMessage() + " " + firebaseError.getDetails());
            }
        });
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