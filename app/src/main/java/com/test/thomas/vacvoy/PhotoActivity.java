package com.test.thomas.vacvoy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;


public class PhotoActivity extends AppCompatActivity{

    Button button;
    ImageView imageView;
    static final int CAM_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_activity);
        button = (Button) findViewById(R.id.button);
        imageView =(ImageView) findViewById(R.id.image_view);

        button.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
            Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(camera_intent.resolveActivity(getPackageManager()) !=null)
                startActivityForResult(camera_intent,CAM_REQUEST);
            }
        });
    }

    private File getFile(){

        File folder = new File("sdcard/camera_app");

        if(!folder.exists())
        {
            folder.mkdir();
        }
        File image_file = new File(folder,"cam_image.jpg");
        return image_file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    //String path = "sdcard/camera_app/cam_image.jpg";
        //imageView.setImageDrawable(Drawable.createFromPath(path));
        if(requestCode == CAM_REQUEST && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap =(Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
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
            startActivity(new Intent(this, UserAreaActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
