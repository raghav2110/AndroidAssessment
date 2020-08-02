package com.example.android.androidassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpScreen extends AppCompatActivity {

    EditText Name,Address,Email,PhoneNo,Password;
    Button signIn;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";
    String name,address,email,phoneNo,password;
    Pattern password_pattern;
    Matcher password_matcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
        Name = findViewById(R.id.et_Name);
        Address = findViewById(R.id.et_Address);
        Email = findViewById(R.id.et_Email);
        PhoneNo = findViewById(R.id.et_PhoneNo);
        Password = findViewById(R.id.et_Password);
        signIn = findViewById(R.id.btn_SignIn);

        validation();

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void validation() {
        Name.addTextChangedListener(signInValidation);
        Address.addTextChangedListener(signInValidation);
        Email.addTextChangedListener(signInValidation);
        PhoneNo.addTextChangedListener(signInValidation);
        Password.addTextChangedListener(signInValidation);
    }
    private TextWatcher signInValidation = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            name = Name.getText().toString().trim();
            address = Address.getText().toString().trim();
            email = Email.getText().toString().trim();
            phoneNo = PhoneNo.getText().toString().trim();
            password = Password.getText().toString().trim();

            password_pattern = Pattern.compile(passwordPattern);
            password_matcher = password_pattern.matcher(password);

            signIn.setEnabled((!name.isEmpty() && name.length()>4) && (!address.isEmpty() && address.length()>10) && (!email.isEmpty() && email.matches(emailPattern)) && (!phoneNo.isEmpty() && phoneNo.length()>10) && (password.length()>8 && password.length()<15 && (password_matcher.matches())));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}
