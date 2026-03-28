package com.example.registrationformwithvalidation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class MessageDialog extends DialogFragment {

    static MessageDialog newInstance(String msg)
    {
        MessageDialog dialog = new MessageDialog();
        Bundle b = new Bundle();
        b.putString("msg",msg);
        dialog.setArguments(b);
        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        String message = getArguments().getString("msg");

        return new AlertDialog.Builder(getActivity())
                .setMessage(message)
                .setPositiveButton("OK", null)
                .create();
    }
}
