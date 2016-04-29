package com.example.root.mentorbuddy;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

/**
 * Created by root on 3/17/16.
 */
public class ComposeDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    public Dialog compose() {

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Dialog Sample").setMessage("Are You Sure");

        builder.create();
        return builder.show();
    }

}
