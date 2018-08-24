package com.example.lalit.eventit;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FrgAddMemebers extends Fragment {

    Button btnAddMember;

    public FrgAddMemebers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_frg_add_memebers, container, false);
        btnAddMember=view.findViewById(R.id.btnAddMember);
        btnAddMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMemberDialog();
            }
        });
        return view;
    }

    private void showMemberDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View promptView = layoutInflater.inflate(R.layout.member_dialog_main, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setView(promptView);


        final EditText etAddMemEmail=promptView.findViewById(R.id.etAddMemEmail);
        final EditText etAddMemeCode=promptView.findViewById(R.id.etAddMemCode);

        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), etAddMemEmail.getText(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(getActivity(), etAddMemeCode.getText(), Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

}
