package com.example.lalit.eventit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FrgMain extends Fragment {


    private Button btnLogin;
    private Button btnSignup;

    public FrgMain() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frg_main, container, false);

        btnLogin=(Button)view.findViewById(R.id.btnLogin);
        btnSignup=(Button)view.findViewById(R.id.btnSignup);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Hello Raju!", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.rlMain,new FrgLogin()).addToBackStack(null).commit();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Hello Raju!", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.rlMain,new FrgSignup()).addToBackStack(null).commit();

            }
        });

        return view;
    }

}
