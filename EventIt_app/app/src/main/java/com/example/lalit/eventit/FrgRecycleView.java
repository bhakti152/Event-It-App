package com.example.lalit.eventit;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FrgRecycleView extends Fragment {

    ImageView notifyImageView;

    public FrgRecycleView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_frg_recycle_view, container, false);

        notifyImageView=view.findViewById(R.id.notifyImageView);
        /*notifyImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNotifyDialog();
            }
        });*/


    return view;
    }

}
