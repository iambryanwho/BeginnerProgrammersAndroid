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
import android.widget.TextView;

import com.codetank.beginnerprogrammers.LoginActivity;

import com.codetank.beginnerprogrammers.R;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

/**
 * Created by jrperiod on 6/15/16.
 */
public class ForgotFragment extends Fragment {

    public static final String FIRE_BASE_URL = "https://bpgo.firebaseio.com/";
    public static final String USERS_ROUTE = "users/";

    Firebase mFireBaseRef;

    private EditText userEmail;
    private Button resetBtn;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.forgot_fragment, container, false);

        userEmail = (EditText) layout.findViewById(R.id.userEmailET);
        resetBtn = (Button) layout.findViewById(R.id.resetBtn);

        //resetBtn.setOnClickListener(this);

        return layout;
    }


    }


