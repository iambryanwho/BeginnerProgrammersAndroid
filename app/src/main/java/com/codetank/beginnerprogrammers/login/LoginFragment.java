package com.codetank.beginnerprogrammers.login;

import android.content.Context;
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

import com.codetank.beginnerprogrammers.Forgot.ForgotFragment;
import com.codetank.beginnerprogrammers.LoginActivity;
import com.codetank.beginnerprogrammers.R;
import com.codetank.beginnerprogrammers.signup.SignUpFragment;

/**
 * Created by manny on 6/15/16.
 */
public class LoginFragment extends Fragment implements View.OnClickListener{

    private EditText userEmail;
    private EditText userPassword;
    private TextView forgotPassword;
    private Button loginBtn;
    private Button signUpBtn;
    private OnLoginListener mListener;

    public LoginFragment(){}

    public interface OnLoginListener{
        void onLogin(String email, String password);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            mListener = (OnLoginListener) getActivity();
        }catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString()
                    + " must implement OnFragment");
        }
    }

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

    public void login(){

        if(userEmail.length() == 0 || userPassword.length() == 0){
            return;
        }

        String email = userEmail.getText().toString();
        String password = userPassword.getText().toString();

        mListener.onLogin(email, password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.forgotPassword:
                LoginActivity activity = (LoginActivity) getActivity();
                activity.replaceFragment(new ForgotFragment());
                Log.d("Flow", "testing forgot");
                break;
            case R.id.loginBtn:
                login();
                break;
            case R.id.signUpBtn:
                //LoginActivity activity = (LoginActivity) getActivity();
                //activity.replaceFragment(new SignUpFragment());
        }
    }
}
