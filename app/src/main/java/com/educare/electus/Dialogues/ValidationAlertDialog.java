package com.educare.electus.Dialogues;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class ValidationAlertDialog {

    private Context context;
    private String errorTitle;
    private String errorMessage;

    public ValidationAlertDialog(Context context, String errorTitle, String errorMessage) {
        this.context = context;
        this.errorTitle = errorTitle;
        this.errorMessage = errorMessage;
        showElectDialog();
    }

    private void showElectDialog() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setTitle(errorTitle);
        builder1.setMessage(errorMessage);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Okay",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}




