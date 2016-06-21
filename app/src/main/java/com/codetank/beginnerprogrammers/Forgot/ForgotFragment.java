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

/**
 * Created by jrperiod on 6/15/16.
 */
public class ForgotFragment extends Fragment {

    private EditText userEmail;
    private Button resetBtn;
    private TextView forgotpassword;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)  {

        View view = inflater.inflate(R.layout.forgot_fragment, container, false);

        userEmail = (EditText) view.findViewById(R.id.userEmailET);
        resetBtn = (Button) view.findViewById(R.id.resetBtn);


        return view;
    }

}
