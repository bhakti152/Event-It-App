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
public class ViewSubevent extends Fragment {

    Button btnSubTicketPremium,btnSubTicketGold,btnSubTicketClassic;
    public ViewSubevent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_view_subevent, container, false);

        btnSubTicketPremium=view.findViewById(R.id.btnSubEventTicketPremium);
        btnSubTicketGold=view.findViewById(R.id.btnSubEventTicketGold);
        btnSubTicketClassic=view.findViewById(R.id.btnSubEventTicketClassic);


        btnSubTicketPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPremiumTicketDialog();
            }
        });

        btnSubTicketGold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showGoldTicketDialog();
            }
        });

        btnSubTicketClassic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showClassicTicketDialog();
            }
        });
        return view;
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

}
