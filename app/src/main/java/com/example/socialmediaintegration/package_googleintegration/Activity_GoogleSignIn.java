package com.example.socialmediaintegration.package_googleintegration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.socialmediaintegration.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;




public class Activity_GoogleSignIn extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
private GoogleApiClient mGoogleApi;
public static final int RC_SIGN_IN=6;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__google_sign_in);
        SignInButton signInButton = findViewById(R.id.sign_in_button);
        textView=findViewById(R.id.text1);
        signInButton.setSize(SignInButton.SIZE_STANDARD);


        //  configure Google Sign-In to request the user data required by your app
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        //so create the GoogleSignInOptions object with the requestEmail option.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleApi = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();

        findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApi);
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });
    }





    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("Code....", String.valueOf(requestCode));

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
           GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        Log.e("GoogleLogin", String.valueOf(result.isSuccess()));
        if(result.isSuccess()){
            GoogleSignInAccount account=result.getSignInAccount();
            textView.setText(account.getDisplayName() +"Email : " +account.getEmail());

        }
        else{
            Toast.makeText(this,"LoginFailed",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
