package com.test.thomas.vacvoy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        helper = new DatabaseHelper(this);
    }
    public void onRegisterClick(View view)
    {
        if(view.getId() == R.id.bRegister)
        {
            EditText etName =  (EditText) findViewById(R.id.etName);
            EditText etUsername =  (EditText) findViewById(R.id.etUsername);
            EditText etPassword =  (EditText) findViewById(R.id.etPassword);

            String namestr = etName.getText().toString();
            String unamestr = etUsername.getText().toString();
            String passstr = etPassword.getText().toString();

            Contact c = new Contact();
            c.setName(namestr);
            c.setPseudo(unamestr);
            c.setPassword(passstr);

            helper.insertContact(c);

            Toast.makeText(this, "Enregistrement effectué", Toast.LENGTH_LONG).show();

            finish();

        }
    }
}
