package com.example.wardrobewizard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ClothDetail extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_IMAGE_PICK = 2;
    private static final int CAMERA_REQUEST = 1888;
    ImageView imageView;

    private Button photoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth_detail);
        imageView = findViewById(R.id.imageView);
        photoButton = findViewById(R.id.cameraButton);
        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }

        public void Gallery(View view) {
        // Open the gallery to select an existing photo
        Intent pickPhotoIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if (pickPhotoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(pickPhotoIntent, REQUEST_IMAGE_PICK);
        } else {
            Toast.makeText(this, "Gallery not available", Toast.LENGTH_SHORT).show();
        }
    }

    // Handle the result of camera or gallery activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
//                case REQUEST_IMAGE_CAPTURE:
//                    // Handle captured image from camera
//                    // You can get the image data from 'data' intent
//                    // Set the captured image to the ImageView
//                    imageView.setImageBitmap((Bitmap) data.getExtras().get("data"));
//                    break;
                case REQUEST_IMAGE_PICK:
                    // Handle selected image from gallery
                    // You can get the image data from 'data' intent
                    // Set the selected image to the ImageView
                    Uri selectedImageUri = data.getData();
                    imageView.setImageURI(selectedImageUri);
                    break;

                case CAMERA_REQUEST:
                    Bitmap photo = (Bitmap) data.getExtras().get("data");
                    imageView.setImageBitmap(photo);

            }
        }
    }
}