package com.example.challange_1;



import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.graphics.Bitmap;


public class MainActivity extends AppCompatActivity {

    public static final int CAMERA_REQUEST=9999;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button click =(Button)findViewById(R.id.shutter);
         imageView = (ImageView)findViewById(R.id.display);


    }


    public void takePhoto(View view){
        Intent intent =new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAMERA_REQUEST){
            Bitmap bitmap =(Bitmap)data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }

    }
}
