package package_loginmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.socialmediaintegration.R;

public class Activity_MainMVP extends AppCompatActivity implements LoginView
{
    private LoginPresenter presenter;
    private EditText textViewUserName;
    private EditText textViewPassword;
    private Button buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();
        presenter = new LoginPresenterImpl(this);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.handleLogin(textViewUserName.getText().toString(), textViewPassword.getText().toString());
            }
        });
    }
    private void initializeView()
    {
        textViewUserName = findViewById(R.id.edittext);
        textViewPassword = findViewById(R.id.edittext1);
        buttonLogin = findViewById(R.id.button);
    }
    @Override
    public void showValidationErrorMsg()
    {
        Toast.makeText(this, "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void loginSuccessFully()
    {
        Toast.makeText(this, "Login SuccessFully", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void loginFail()
    {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
    }
}
