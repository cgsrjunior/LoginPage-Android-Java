package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.loginpage.LoginClass;

public class MainActivity extends AppCompatActivity {

    LoginClass login_info = new LoginClass();

    Button exit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(login_info.getPassword_attempts() != 3){
            login_info = new LoginClass(findViewById(R.id.username),findViewById(R.id.password),findViewById(R.id.loginButton));
        } else {
            login_info.setUsername(findViewById(R.id.username));
            login_info.setPassword(findViewById(R.id.password));
            login_info.setLogin_button(findViewById(R.id.loginButton));
        }

        exit_btn = findViewById(R.id.exitButton);

        login_info.getLogin_button().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(login_info.loginAttempt(login_info))
                {
                    Toast.makeText(MainActivity.this, "Password Correct!!! Login successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, login_info.getPassword_attempts()+" attempts remaining", Toast.LENGTH_SHORT).show();
                    if (login_info.getPassword_attempts() == 0){
                        Toast.makeText(MainActivity.this, "Your user is locked!!! Click On Exit", Toast.LENGTH_SHORT).show();
                        login_info.disableButton();
                    }
                }
            }
        });

        exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
}