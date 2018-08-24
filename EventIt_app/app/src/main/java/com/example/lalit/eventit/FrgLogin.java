package com.example.lalit.eventit;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FrgLogin extends Fragment {

    EditText etEmail;
    EditText etPassword;
    TextView tvForgotPassword;
    Button btnSignin;
    UserSessionManager session;

    public FrgLogin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frg_login, container, false);
        session = new UserSessionManager(getContext());
        etEmail=view.findViewById(R.id.etEmail);
        etPassword=view.findViewById(R.id.etPassword);
        tvForgotPassword=(TextView)view.findViewById(R.id.tvForgotPassword);
        btnSignin=(Button)view.findViewById(R.id.btnSignin);
        Toast.makeText(getContext(),
                "User Login Status: " + session.isUserLoggedIn(),
                Toast.LENGTH_LONG).show();
        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Ab kuch nai ho sakta!", Toast.LENGTH_SHORT).show();
            }
        });

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get username, password from EditText
                String username = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                // Validate if username, password is filled
                if(username.trim().length() > 0 && password.trim().length() > 0){

                    // For testing puspose username, password is checked with static data
                    // username = admin
                    // password = admin

                    if(username.equals("admin") && password.equals("admin")){

                        // Creating user login session
                        // Statically storing name="Android Example"
                        // and email="androidexample84@gmail.com"
                        session.createUserLoginSession("Android Example",
                                "androidexample84@gmail.com");

                        // Starting MainActivity
                        Intent i = new Intent(getContext(), MainEventActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        // Add new Flag to start new Activity
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);

                       // finish();
                        getActivity().getFragmentManager().popBackStack();
                    }else{

                        // username / password doesn't match&
                        Toast.makeText(getContext(),
                                "Username/Password is incorrect",
                                Toast.LENGTH_LONG).show();

                    }
                }else{

                    // user didn't entered username or password
                    Toast.makeText(getContext(),
                            "Please enter username and password",
                            Toast.LENGTH_LONG).show();

                }

            }
        });



       /* btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Api kon implement Karega?", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.rlMain,new FrgSignup()).commit();
                // getChildFragmentManager().beginTransaction().replace(R.id.llMain2,new Main2Activity()).commit();
            }
        });*/
        return view;


    }

    //bhakti


//    Intent intent =new Intent(getActivity(),MainEventActivity.class);
//    startActivity(intent);


}



