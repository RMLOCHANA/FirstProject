package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RelativeLayout btn_signup;
    EditText et_username,et_password;
    TextView textView3;

    private String EmailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private String MobilePattern = "^\\+[0-9]{10,13}$";
    private String PasswordPattern = "[a-zA-Z0-9\\\\!\\\\@\\\\#\\\\$]{8,24}";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = findViewById(R.id.editText5);
        et_password = findViewById(R.id.editText6);
        btn_signup = findViewById(R.id.btn_click);
        textView3 = findViewById(R.id.textView3);

        String text = "<font> Don't have an account?</font> <font color = #FFA900> <b>Sign Up</b></font>";
        String texttwo = "hellow word";
        textView3.setText(Html.fromHtml(text));
        textView3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"Logged in successfull",Toast.LENGTH_SHORT).show();
                validateFields();

            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity. this, SignUp.class);
                startActivity(intent);
            }
        });


    }

    private void LogUser() {
        Intent intent = new Intent(MainActivity.this,HomePage.class);
        startActivity(intent);
    }

    private void validateFields() {
        //validate fields
        String username,password;
        username = et_username.getText().toString();
        password = et_password.getText().toString();

        if (!(username.isEmpty())) {
            if (!(password.isEmpty())) {
                       //  Toast.makeText(MainActivity.this, "Hello User " + username + " Welcome!",Toast.LENGTH_SHORT).show();
                if (username.matches(EmailPattern)){
                    if (password.matches(PasswordPattern)){
                        LogUser();
                        Toast.makeText(MainActivity.this, "Welcome to ASR DMC " ,Toast.LENGTH_SHORT).show();

                    }else {
                        et_password.setError("Password length should 8-24");
                    }

                }else  {
                    et_username.setError("Invalid User Name or email");
                }

            } else {

                et_password.setError("Enter the password");
            }
        }else {

            et_username.setError("Enter the user name");
        }


       // Toast.makeText(MainActivity.this, "Hello User " + username,Toast.LENGTH_SHORT).show();


    }
}