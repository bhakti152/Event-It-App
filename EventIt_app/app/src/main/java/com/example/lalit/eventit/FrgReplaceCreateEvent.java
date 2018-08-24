package com.example.lalit.eventit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FrgReplaceCreateEvent extends Fragment {
    Button btnCreateEvent;

    public FrgReplaceCreateEvent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_frg_replace_create_event, container, false);

        btnCreateEvent=(Button)view.findViewById(R.id.btnCreateEvent);

       /* btnCreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new FrgCreateEvent()).commit();
            }
        });*/
        return view;
    }

}
