package com.example.databaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView text = findViewById(R.id.registerLink);
        SpannableString spannableString = new SpannableString(text.getText());
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        };
        spannableString.setSpan(clickableSpan, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text.setText(spannableString);
        text.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void loginBtn(View view) {
        _checkUser();
    }

    private void _checkUser() {
        DBConnector connector = new DBConnector(this, null);

        EditText username = findViewById(R.id.loginUsernameText);
        EditText password = findViewById(R.id.loginPasswordText);

        boolean success = connector.checkLogin(username.getText().toString(), password.getText().toString());
        if (success) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else
            Toast.makeText(this, "Username or password not recognised", Toast.LENGTH_SHORT).show();
    }

}