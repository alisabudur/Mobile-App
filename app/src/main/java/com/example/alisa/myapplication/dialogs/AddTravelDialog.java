package com.example.alisa.myapplication.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.*;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;

import com.example.alisa.myapplication.R;
import com.example.alisa.myapplication.TravelListActivity;
import com.example.alisa.myapplication.domain.Travel;
import com.example.alisa.myapplication.repositories.TravelDbRepository;
import com.example.alisa.myapplication.repositories.interfaces.ITravelRepository;

/**
 * Created by Alisa on 12/2/2016.
 */

public class AddTravelDialog extends DialogFragment {

    private NoticeDialogListener mListener;

    public interface NoticeDialogListener {
        void onDialogPositiveClick(DialogInterface dialog);
        void onDialogNegativeClick(DialogInterface dialog);
    }

    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setTitle(R.string.addTitle);
        builder.setView(inflater.inflate(R.layout.dialog_add_travel, null))
                .setPositiveButton(R.string.addTravel, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.onDialogPositiveClick(dialog);
                    }
                })
                .setNegativeButton(R.string.cancelAdd, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.onDialogNegativeClick(dialog);
                    }
                });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (NoticeDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement NoticeDialogListener");
        }
    }
}
