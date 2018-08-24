package com.example.lalit.eventit;


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FrgSubevent extends Fragment {

    Button btnSubEventTicketPremium;
    Button btnSubEventTicketGold;
    Button btnSubEventTicketClassic;
    public FrgSubevent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_frg_subevent, container, false);
      btnSubEventTicketPremium=view.findViewById(R.id.btnSubEventTicketPremium);
        btnSubEventTicketPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Hota h click", Toast.LENGTH_SHORT).show();
            }
        });
        Toast.makeText(getContext(), " Sub Event", Toast.LENGTH_SHORT).show();
        return view;
    }
}
