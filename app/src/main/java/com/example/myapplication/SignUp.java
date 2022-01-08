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

public class SignUp extends AppCompatActivity {
    EditText et_mobile_number_or_email, et_full_name, et_user_name, et_password;
    TextView tv_sign_in;
    RelativeLayout btn_click_create;

    private String EmailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private String MobilePattern = "^\\+[0-9]{10,13}$";
    private String PasswordPattern = "[a-zA-Z0-9\\\\!\\\\@\\\\#\\\\$]{8,24}";
    private String UserNamePattern = "^([a-zA-Z])+([\\w@]{4,})+$";
    private String CapitalPattern = "^[a-zA-Z][ ]*$\"";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        et_mobile_number_or_email = findViewById(R.id.signup4);
        et_full_name = findViewById(R.id.signup);
        et_user_name = findViewById(R.id.signup5);
        et_password = findViewById(R.id.signup6);
        tv_sign_in = findViewById(R.id.signup16);
        btn_click_create = findViewById(R.id.btn_click);

        String text = "<font> Already have an account?</font> <font color = #FFA900> <b>Sign In</b></font>";
        String texttwo = "hellow word";
        tv_sign_in.setText(Html.fromHtml(text));

        btn_click_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateFields();

            }
        });

        tv_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    private void LogUser() {
        Intent intent = new Intent(SignUp.this, HomePage.class);
        startActivity(intent);
    }

    private void validateFields() {
        String Mobile_Number_Or_Email, Full_Name, User_Name, Password;

        Mobile_Number_Or_Email = et_mobile_number_or_email.getText().toString();
        Full_Name = et_full_name.getText().toString();
        User_Name = et_user_name.getText().toString();
        Password = et_password.getText().toString();

        if (!(Mobile_Number_Or_Email.isEmpty())) {
            if (!(Full_Name.isEmpty())) {
                if (!(User_Name.isEmpty())) {
                    if (!(Password.isEmpty())) {
                        if (Mobile_Number_Or_Email.matches(EmailPattern)) {
                            if (Full_Name.matches(PasswordPattern)) {
                                if (User_Name.matches(UserNamePattern)) {
                                    if (Password.matches(PasswordPattern)) {
                                        LogUser();
                                        Toast.makeText(SignUp.this, "Hello " + User_Name,Toast.LENGTH_SHORT).show();

                                    }else {
                                        et_password.setError("Password length should 8-24");
                                    }

                                }else {
                                    et_user_name.setError("Minimum 5 characters required for user name");
                                }

                            }else {
                                et_full_name.setError("Inter your full name");
                            }

                        }else {
                            et_mobile_number_or_email.setError("Enter valid email address");
                        }

                    }else {
                        et_password.setError("Enter the password");
                    }

                }else {

                    et_user_name.setError("Enter the user name");
                }

            }else {

                et_full_name.setError("Enter the full name");
            }

            }else {

            et_mobile_number_or_email.setError("Enter the mobile number or email");
        }

    }
}