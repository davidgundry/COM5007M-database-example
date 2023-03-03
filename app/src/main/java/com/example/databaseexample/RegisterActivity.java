package com.example.databaseexample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void registerBtn(View view)
    {
        this._addNewUser();
    }

    private void _addNewUser()
    {
        DBConnector connector = new DBConnector(this, null);

        EditText name = findViewById(R.id.registerNameText);
        EditText username = findViewById(R.id.registerUsernameText);
        EditText password = findViewById(R.id.registerPasswordText);

        connector.addNewUser(name.getText().toString(), username.getText().toString(), password.getText().toString());

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}