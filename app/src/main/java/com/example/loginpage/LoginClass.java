package com.example.loginpage;

import android.widget.Button;
import android.widget.EditText;

public class LoginClass {
    EditText username;
    EditText password;
    Button login_button;
    private boolean login_successful;
    private int password_attempts;

    public EditText getUsername() {
        return username;
    }

    public void setUsername(EditText username) {
        this.username = username;
    }

    public EditText getPassword() {
        return password;
    }

    public void setPassword(EditText password) {
        this.password = password;
    }

    public Button getLogin_button() {
        return login_button;
    }

    public void setLogin_button(Button login_button) {
        this.login_button = login_button;
    }

    public int getPassword_attempts() {
        return password_attempts;
    }

    public void setPassword_attempts(int password_attempts) {
        this.password_attempts = password_attempts;
    }

    public void subtractPassword_attempts() {
        this.password_attempts = password_attempts - 1;
    }

    public boolean isLogin_successful() {
        return login_successful;
    }

    public void setLogin_successful(boolean login_successful) {
        this.login_successful = login_successful;
    }

    public LoginClass(){
        this.password_attempts = 0;
    }

    public LoginClass(EditText username, EditText password, Button login_button) {
        this.username = username;
        this.password = password;
        this.login_button = login_button;
        this.password_attempts = 3;
        this.login_successful = false;
    }

    public boolean loginAttempt(LoginClass login_form) {
        if (password_attempts != 0) {
            if (username.getText().toString().equals("Cleiber") &&
                    password.getText().toString().equals("entrada@123")) {
                //Restore the attempts and set the flag to true
                setPassword_attempts(3);
                setLogin_successful(true);
            } else {
                //Decrease one attempt for user
                subtractPassword_attempts();
            }
        }
        return isLogin_successful();
    }

    public void disableButton() {
        this.login_button.setEnabled(false);
    }
}
