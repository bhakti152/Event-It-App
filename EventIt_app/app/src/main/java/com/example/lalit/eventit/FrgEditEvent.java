package com.example.lalit.eventit;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;



/**
 * A simple {@link Fragment} subclass.
 */
public class FrgEditEvent extends Fragment {

    Switch swHasSubEvent;
    Button btnMainTicketPremium,btnMainTicketGold,btnMainTicketClassic;


    public FrgEditEvent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_frg_edit_event, container, false);
       
       final Switch swHasSubEvent = (Switch)view.findViewById(R.id.swHasSubEvent);
        Button btnPublish = (Button) view.findViewById(R.id.btnPublish);
        Button btnCancel = (Button) view.findViewById(R.id.btnCancel);

        btnMainTicketPremium=view.findViewById(R.id.btnMainEventTicketPremium);
        btnMainTicketGold=view.findViewById(R.id.btnMainEventTicketGold);
        btnMainTicketClassic=view.findViewById(R.id.btnMainEventTicketClassic);
      

        btnPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(swHasSubEvent.isChecked())
                    getFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new FrgSubevent()).commit();
                else
                    getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new FrgCardView()).commit();
            }
        });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new FrgCardView()).commit();
            }
        });

        btnMainTicketPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPremiumTicketDialog();
            }
        });

        btnMainTicketGold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showGoldTicketDialog();
            }
        });

        btnMainTicketClassic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showClassicTicketDialog();
            }
        });
      
     return view;
    }

    private void showClassicTicketDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View promptView = layoutInflater.inflate(R.layout.classic_ticket_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setView(promptView);


        final EditText etAddClassicQuantity=promptView.findViewById(R.id.etAddClassicQuantity);
        final EditText etAddClassicPrice=promptView.findViewById(R.id.etAddClassicPrice);

        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("Add Ticket", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), etAddClassicQuantity.getText(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(getActivity(), etAddClassicPrice.getText(), Toast.LENGTH_SHORT).show();

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

    private void showGoldTicketDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View promptView = layoutInflater.inflate(R.layout.gold_ticket_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setView(promptView);


        final EditText etAddGoldQuantity=promptView.findViewById(R.id.etAddGoldQuantity);
        final EditText etAddGoldPrice=promptView.findViewById(R.id.etAddGoldPrice);

        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("Add Ticket", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), etAddGoldQuantity.getText(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(getActivity(), etAddGoldPrice.getText(), Toast.LENGTH_SHORT).show();

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

    private void showPremiumTicketDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View promptView = layoutInflater.inflate(R.layout.premium_ticket_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setView(promptView);


        final EditText etAddPremiumQuantity=promptView.findViewById(R.id.etAddPremiumQuantity);
        final EditText etAddPremiumPrice=promptView.findViewById(R.id.etAddPremiumPrice);

        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("Add Ticket", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), etAddPremiumQuantity.getText(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(getActivity(), etAddPremiumPrice.getText(), Toast.LENGTH_SHORT).show();

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


