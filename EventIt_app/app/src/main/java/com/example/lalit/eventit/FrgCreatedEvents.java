package com.example.lalit.eventit;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FrgCreatedEvents extends Fragment {

    Button btnGoingEvent;
    Button btnViewSubevents;
    public FrgCreatedEvents() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_frg_created_events, container, false);

        btnGoingEvent=(Button)view.findViewById(R.id.btnGoingEvent);
        btnViewSubevents=(Button)view.findViewById(R.id.btnViewSubevents);
        //Button Going -- Not going listener
        btnGoingEvent.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                if(btnGoingEvent.getText().equals("Not Going")){
                    btnGoingEvent.setTextColor(getResources().getColor(R.color.colorPurple));
                    btnGoingEvent.setBackground(getResources().getDrawable(R.drawable.btn_login_main));
                    btnGoingEvent.setText("Going");
                }
                else {
                    btnGoingEvent.setTextColor(getResources().getColor(R.color.white));
                    btnGoingEvent.setBackground(getResources().getDrawable(R.drawable.et_border));
                    btnGoingEvent.setText("Not Going");
                }
            }

        });
        //Button Going -- Not going listener
        //Button view subevents listener
        btnViewSubevents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new ViewSubevent()).commit();
            }
        });
        //Button view subevents listener
        return view;
    }

}
