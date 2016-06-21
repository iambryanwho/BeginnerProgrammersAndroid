package com.codetank.beginnerprogrammers.Forgot;

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
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

/**
 * Created by jrperiod on 6/15/16.
 */
public class ForgotFragment extends Fragment implements View.OnClickListener{

    public static final String FIRE_BASE_URL = "https://bpgo.firebaseio.com/";
    public static final String USERS_ROUTE = "users/";

    Firebase mFireBaseRef;

    private EditText userEmailReset;
    private Button resetBtn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFireBaseRef = new Firebase(FIRE_BASE_URL + USERS_ROUTE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.forgot_fragment, container, false);

        userEmailReset = (EditText) layout.findViewById(R.id.emailET);
        resetBtn = (Button) layout.findViewById(R.id.resetBtn);

        resetBtn.setOnClickListener(this);

        return layout;
    }

    public void resetPassword(){

        if(!resetCredentialsValidated()){
            return;
        }

        mFireBaseRef.resetPassword(userEmailReset.getText().toString(), new Firebase.ResultHandler() {
            @Override
            public void onSuccess() {
                Log.d("flow", "Send to " + userEmailReset.getText().toString());
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                Log.d("flow", "ERROR: " + firebaseError.toString() + " " + firebaseError.getMessage() + " " + firebaseError.getDetails());
            }
        });

    }

    public boolean resetCredentialsValidated(){
        boolean isValid = true;

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(userEmailReset.getText().toString()).matches()){
            isValid = false;
        }

        return  isValid;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
            resetPassword();
    }
}