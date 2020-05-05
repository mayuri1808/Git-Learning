package com.example.socialmediaintegration.package_Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.socialmediaintegration.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Activity_Login extends AppCompatActivity {
EditText email,password;
Button loginButton;
String emailtext,passtext;
TextView forgotPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__login);
        email=findViewById(R.id.edittext);
        password=findViewById(R.id.edittext1);
        forgotPass=findViewById(R.id.forgottext);
        loginButton=findViewById(R.id.button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailtext = email.getText().toString().trim();
                passtext = password.getText().toString().trim();
                validations();
            }
        });

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_Login.this,Activity_ForgotPassword.class);
                startActivity(intent);
            }
        });
    }


    public static boolean isPasswordValid(String pass) {
        boolean isValid = false;

        String PassPattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
        // CharSequence inputemail = email;

        Pattern pattern = Pattern.compile(PassPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(pass);
//        if (matcher.matches()) {
//            isValid = true;
//        }
//        return isValid;
        return matcher.matches();
    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String EmailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        // CharSequence inputemail = email;

        Pattern pattern = Pattern.compile(EmailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
//        if (matcher.matches()) {
//            isValid = true;
//        }
//        return isValid;
        return matcher.matches();
    }


    public boolean validations() {
        if (!isEmailValid(emailtext)) {
            Toast.makeText(Activity_Login.this, "Please Enter Valid EmailId", Toast.LENGTH_LONG).show();
            return false;
        } else if (!isPasswordValid(passtext)) {
            Toast.makeText(Activity_Login.this, "Please Enter Valid Password", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;

    }

}
