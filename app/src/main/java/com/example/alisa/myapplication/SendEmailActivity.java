package com.example.alisa.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SendEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);
    }

    public void sendEmail(View view) {
        final EditText editEmail = (EditText) findViewById(R.id.editEmail);
        final EditText editStartLocation = (EditText) findViewById(R.id.editStartLocationE);
        final EditText editEndLocation = (EditText) findViewById(R.id.editEndLocationE);

        String email = editEmail.getText().toString();
        String start = editStartLocation.getText().toString();
        String destination = editEndLocation.getText().toString();
        String emailText = "Salut, \n\n O sa calatoresc de la " + start + " la " + destination + "! \n\n O zi frumoasa!";

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", email, null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Calatorie");
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailText);
        startActivityForResult(Intent.createChooser(emailIntent, "Send email..."), 1);
    }

    public void cancel(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
