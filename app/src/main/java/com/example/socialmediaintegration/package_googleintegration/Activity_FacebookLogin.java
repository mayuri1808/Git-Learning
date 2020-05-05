package com.example.socialmediaintegration.package_googleintegration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.socialmediaintegration.R;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

import static android.provider.ContactsContract.Intents.Insert.EMAIL;

//private static final String EMAIL = "email";

public class Activity_FacebookLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__facebook_login);
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList(EMAIL));
    }
}
