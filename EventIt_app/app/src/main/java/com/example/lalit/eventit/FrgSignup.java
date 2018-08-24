package com.example.lalit.eventit;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class FrgSignup extends Fragment {

    EditText etFirstName;
    EditText etLastName;
    EditText etEmail;
    EditText etPassword;
    EditText etConfirmPassword;
    Button btnSubmit;


    String firstName;
    String lastName;
    String email;
    String password;
    String confirmPassword;

    public FrgSignup() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frg_signup, container, false);
        etFirstName=(EditText) view.findViewById(R.id.etFirstName);
        etLastName=(EditText) view.findViewById(R.id.etLastName);
        etEmail=(EditText) view.findViewById(R.id.etEmail);
        etPassword=(EditText) view.findViewById(R.id.etPassword);
        etConfirmPassword=(EditText) view.findViewById(R.id.etConfirmPassword);
        btnSubmit = (Button) view.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),MainEventActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    public void senddatatoserver(View v) {
        //function in the activity that corresponds to the layout button
        firstName = etFirstName.getText().toString();
        lastName= etLastName.getText().toString();
        email= etFirstName.getText().toString();
        password=etPassword.getText().toString();
        confirmPassword=etConfirmPassword.getText().toString();
//        if(password.equals(confirmPassword))
//        {
            JSONObject post_dict = new JSONObject();

            try {

//               post_dict.put("firstname" , firstName);
//               post_dict.put("lastname", lastName);
//               post_dict.put("email", email);
//               post_dict.put("password", password);
//                post_dict.put("name" , firstName);
//                post_dict.put("country", lastName);
//                post_dict.put("twitter", email);
                post_dict.put("usertype_id",2);
                post_dict.put("user_first_name",firstName);
                post_dict.put("user_last_name",lastName);
                post_dict.put("user_email",email);
                post_dict.put("user_password",password);
//                post_dict.put("user_phone_number","123456789");
//                post_dict.put("user_aadhar_card_number","123456789");
//                post_dict.put("user_profile_picture","Bhakti hjcsh ksj");
//                post_dict.put("user_about","Bhakti bjdc");
//                post_dict.put("user_residence","Bhakti djcnkjcds");
//                post_dict.put("user_city","gandhinagar");
//                post_dict.put("user_country","INDIA");

            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (post_dict.length() > 0) {
                new com.example.lalit.eventit.SendJsonDataToServer().execute(String.valueOf(post_dict));

            }
//add background inline class here

//        }else
//        {
//            Toast.makeText(getActivity(),"Wrong Password",Toast.LENGTH_SHORT).show();
//        }

    }



}
