package package_loginmvp;

import android.text.TextUtils;

public class LoginPresenterImpl implements LoginPresenter
{
    private LoginView loginView;
    public LoginPresenterImpl(LoginView loginView)
    {
        this.loginView = loginView;
    }
    @Override
    public void handleLogin(String username, String password)
    {
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            loginView.showValidationErrorMsg();
        }
        else
        {
            if (username.equals("Standerd") && password.equals("Standerd"))
            {
                loginView.loginSuccessFully();
            }
            else
            {
                loginView.loginFail();
            }
        }
    }
}
