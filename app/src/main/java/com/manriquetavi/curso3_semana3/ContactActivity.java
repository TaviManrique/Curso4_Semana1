package com.manriquetavi.curso3_semana3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.content.AsyncTaskLoader;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText textEditInputName;
    private EditText textEditInputEmail;
    private EditText textEditInputMessage;
    private String sEmail, sPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        toolbar = findViewById(R.id.includeActionBarContact);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textEditInputEmail = (EditText) findViewById(R.id.textEditInputEmail);
        textEditInputName = (EditText) findViewById(R.id.textEditInputName);
        textEditInputMessage = (EditText) findViewById(R.id.textEditInputMessage);

        sEmail = "pruebadev61@gmail.com";
        sPassword = "teve123!";
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        finish();
        return false;
    }

    public void enviarMail(View view) {

        /*
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.user", sEmail);
        properties.put("mail.password", sPassword);

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sEmail, sPassword);
            }
        });

        MimeMessage message = new MimeMessage(session);
        try {
            message.setText(textEditInputMessage.getText().toString());
            message.setFrom(new InternetAddress(sEmail));
            InternetAddress[]direcciones= new InternetAddress[]{new InternetAddress(textEditInputEmail.getText().toString())};
            message.setRecipients(Message.RecipientType.TO,direcciones);
            message.setSubject(textEditInputName.getText().toString());
            new SendEmail().execute(message);
        }
        catch (MessagingException e) {
            e.printStackTrace();
        }*/

        //----------------------------------------------------------------------------------------//

        /*
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.startlls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        //Initialize session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sEmail, sPassword);
            }
        });

        try {
            //Initialize email content
            Message message = new MimeMessage(session);
            //Sender email
            message.setFrom(new InternetAddress(sEmail));
            //Recipient email
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(textEditInputEmail.getText().toString().trim()));
            //Email subject
            message.setSubject(textEditInputName.getText().toString().trim());
            //Email message
            message.setText(textEditInputMessage.getText().toString().trim());

            //Send Email
            new SendEmail().execute(message);
        }
        catch (MessagingException e){
            e.printStackTrace();
        }*/

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        try {
            Session session = Session.getInstance(properties,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(sEmail, sPassword);
                        }
                    });

            if (session != null) {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(sEmail));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(textEditInputEmail.getText().toString().trim()));
                message.setSubject(textEditInputName.getText().toString().trim());
                message.setText(textEditInputMessage.getText().toString().trim());
                new SendEmail().execute(message);
                //Transport.send(message);
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private class SendEmail extends AsyncTask<Message, String, String> {
        //Initilize progress dialog
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Create and show progress dialog
            progressDialog = ProgressDialog.show(ContactActivity.this,"Please wait",
                    "Sending Mail...",true, false);
        }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                //When success
                Transport.send(messages[0]);
                return "Success";
            } catch (MessagingException e){
                //When error
                e.printStackTrace();
                return "Error";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Dismiss progress dialog
            progressDialog.dismiss();
            if (s.equals("Success")){
                //When Success

                //Initialize
                AlertDialog.Builder builder = new AlertDialog.Builder(ContactActivity.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color='#509324'>Success</font>"));
                builder.setMessage("Mail send succesfully.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //Clear all edit text
                        textEditInputEmail.setText("");
                        textEditInputName.setText("");
                        textEditInputMessage.setText("");
                    }
                });
                //Show alert dialog
                builder.show();
            }
            else {
                Toast.makeText(getApplicationContext(),
                        "Something went wrong?", Toast.LENGTH_LONG).show();
            }
        }
    }
}