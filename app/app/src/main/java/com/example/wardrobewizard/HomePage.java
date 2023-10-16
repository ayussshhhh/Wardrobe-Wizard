package com.example.wardrobewizard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }
    public void clicked(View view)
    {
        int ids[]={R.id.Shirt,R.id.Pant,R.id.Tops,R.id.Coat,R.id.Onepiece,R.id.Skirt,R.id.Shoes,R.id.Misc};
        String types[]={"Shirt","Pant","Top","Coat","One-Piece","Skirt","Shoes","Misc"};
        String type="";
        int id = view.getId();
        for(int i=0;i<ids.length;i++)
        {
            if(id==ids[i])
            {
                type=types[i];
                TextView name=findViewById(R.id.Name);
                name.setText(type);
            }
        }
        //call new intent and set data as type
    }
    public void navbarclicked(View view)
    {
        int ids[]={R.id.Shop,R.id.Favorite,R.id.Add,R.id.Gallery,R.id.Donate};
        String types[]={"Shop","Favorite","Camera","Gallery","Donate"};
        String type="";
        int id = view.getId();
        for(int i=0;i<ids.length;i++)
        {
            if(id==ids[i])
            {
                type=types[i];
                TextView name=findViewById(R.id.Name);
                name.setText(type);
                if(type.equals("Shop"))
                {
                    Intent shop = new Intent(HomePage.this, ShoppingPage.class);
                    startActivity(shop);
                } else if (type.equals("Gallery")) {
                    Intent galleryIntent = new Intent(Intent.ACTION_VIEW);
                    galleryIntent.setType("image/*"); // Limit to images only
                    startActivity(galleryIntent);

                } else if (type.equals("Camera")) {
                    openCamera();
                }
            }
        }
        //load next intent
    }
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private Uri imageUri;
    private void openCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(takePictureIntent);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create a file to save the image
            File photoFile = createImageFile();

            if (photoFile != null) {
                imageUri = FileProvider.getUriForFile(this, "your.package.name.fileprovider", photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    private File createImageFile() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        try {
            return File.createTempFile(imageFileName, ".jpg", storageDir);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // The image has been captured and saved. You can use 'imageUri' to access the captured image.
            // For example, you can display it in an ImageView.

        }
    }

    public void navAdd(View view) {
        Intent intent = new Intent(this, ClothDetail.class);
        startActivity(intent);
    }
}