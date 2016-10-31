package com.test.thomas.vacvoy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        helper = new DatabaseHelper(this);
    }

    public void onButtonClick(View v)
    {
        if(v.getId() == R.id.bLogin) {
            EditText etUsername = (EditText) findViewById(R.id.etUsername);
            EditText etPassword = (EditText) findViewById(R.id.etPassword);
            String str = etUsername.getText().toString();
            String pass = etPassword.getText().toString();

            String password = helper.searchPass(str);

            if (pass.equals(password)) {
                Intent i = new Intent(LoginActivity.this, UserAreaActivity.class);
                i.putExtra("pseudo", str);
                startActivity(i);
            }
            else{
                Toast temp = Toast.makeText(LoginActivity.this, "Le mot de passe ou le pseudo ne correspond pas", Toast.LENGTH_SHORT);
                temp.show();
            }
        }
        if(v.getId() == R.id.tvRegisterHere){
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }

    }
}
