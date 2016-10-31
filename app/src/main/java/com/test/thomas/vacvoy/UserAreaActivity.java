package com.test.thomas.vacvoy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        OnclickButtonListener();
        onClickButton2();
        onClickButton3();
    }


    private static Button button1;
    //private static final String TAG = "FragmentActivity";
    private static Button button2;
    private static Button button3;

    public  void OnclickButtonListener(){

        button1 = (Button)findViewById(R.id.button);
        button1.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent i = new Intent(UserAreaActivity.this, ListContact.class);
                        startActivity(i);
                    }
                }
        );
    }

    public void onClickButton2(){
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(
                new View.OnClickListener(){
                    /**
                     * Called when a view has been clicked.
                     *
                     * @param v The view that was clicked.
                     */
                    @Override
                    public void onClick(View v) {
                        Intent j = new Intent(UserAreaActivity.this, PhotoActivity.class);
                        startActivity(j);
                    }
                }
        );
    }

    public void onClickButton3(){
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(
                new View.OnClickListener(){
                    /**
                     * Called when a view has been clicked.
                     *
                     * @param v The view that was clicked.
                     */
                    @Override
                    public void onClick(View v) {
                        Intent j = new Intent(UserAreaActivity.this, MapsActivity.class);
                        startActivity(j);
                    }
                }
        );
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(),"Configuration séléctionnée", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.action_bold) {
            Toast.makeText(getApplicationContext(),"Rafraichissage fait", Toast.LENGTH_LONG).show();
            return true;
        }
        if(id==R.id.navigate){
            startActivity(new Intent(this, LoginActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
