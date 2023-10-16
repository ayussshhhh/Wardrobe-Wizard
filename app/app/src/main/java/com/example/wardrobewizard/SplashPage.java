package com.example.wardrobewizard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wardrobewizard.R.id;
import com.example.wardrobewizard.R.layout;
import com.example.wardrobewizard.R.raw;

public class SplashPage extends AppCompatActivity {
    VideoView vv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_splash_page);
        Toast.makeText(this, "Wardrobe Wizard", Toast.LENGTH_SHORT).show();

        int videoResourceID = raw.logoanimation;
        this.vv = (VideoView)this.findViewById(id.videoView);
        Uri videoUri = Uri.parse("android.resource://" + this.getPackageName() + "/" + videoResourceID);
        this.vv.setVideoURI(videoUri);
        this.vv.start();

        (new Handler(Looper.getMainLooper())).postDelayed(new Runnable() {
            public void run() {
                SplashPage.this.startActivity(new Intent(SplashPage.this, EntryPage.class));
                SplashPage.this.finish();
            }
        }, 4000L);
    }
}
